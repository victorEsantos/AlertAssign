package com.victor.alertassign.task.service;

import com.victor.alertassign.job.service.DynamicJobService;
import com.victor.alertassign.task.CreateTaskUseCase;
import com.victor.alertassign.task.domain.Task;
import com.victor.alertassign.task.domain.TaskDomainRepository;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateTaskService implements CreateTaskUseCase {

    private final TaskDomainRepository repository;
    private final DynamicJobService jobService;

    @Override
    public UUID handle(CreateTaskCommand cmd) throws SchedulerException {
        UUID jobFrequencyId = UUID.randomUUID();
        UUID jobRotationId = UUID.randomUUID();

        Task task = Task.builder()
                .id(UUID.randomUUID())
                .description(cmd.description())
                .alertFrequency(cmd.alertFrequency())
                .jobFrequencyId(jobFrequencyId)
                .rotationFrequency(cmd.rotationFrequency())
                .jobRotationId(jobRotationId)
                .build();

        jobService.registerAlertJob(jobFrequencyId.toString(), task.getAlertFrequency().getCron(), task.getId().toString());
        jobService.registerRotationJob(jobRotationId.toString(), task.getRotationFrequency().getCron(), task.getId().toString());

        repository.save(task);

        return task.getId();
    }
}
