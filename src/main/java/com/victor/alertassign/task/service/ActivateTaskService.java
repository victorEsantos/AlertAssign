package com.victor.alertassign.task.service;

import com.victor.alertassign.job.service.DynamicJobService;
import com.victor.alertassign.task.ActivateTaskUseCase;
import com.victor.alertassign.task.domain.Task;
import com.victor.alertassign.task.domain.TaskDomainRepository;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ActivateTaskService implements ActivateTaskUseCase {

    private final TaskDomainRepository repository;
    private final DynamicJobService jobService;

    @Override
    public void handle(UUID taskId) throws SchedulerException {
        UUID jobFrequencyId = UUID.randomUUID();
        UUID jobRotationId = UUID.randomUUID();

        Task task = repository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.activate(jobFrequencyId, jobRotationId);

        jobService.registerAlertJob(jobFrequencyId.toString(), task.getAlertFrequency().getCron(), task.getId().toString());
        jobService.registerRotationJob(jobRotationId.toString(), task.getRotationFrequency().getCron(), task.getId().toString());


        repository.save(task);

    }
}
