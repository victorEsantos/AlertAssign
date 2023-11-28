package com.victor.alertassign.task.service;

import com.victor.alertassign.task.CreateTaskUseCase;
import com.victor.alertassign.task.domain.Task;
import com.victor.alertassign.task.domain.TaskDomainRepository;
import com.victor.alertassign.task.domain.enums.StatusTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateTaskService implements CreateTaskUseCase {

    private final TaskDomainRepository repository;

    @Override
    public UUID handle(CreateTaskCommand cmd) {

        Task task = Task.builder()
                .id(UUID.randomUUID())
                .description(cmd.description())
                .alertFrequency(cmd.alertFrequency())
                .jobFrequencyId(null)
                .rotationFrequency(cmd.rotationFrequency())
                .status(StatusTask.DRAFT)
                .jobRotationId(null)
                .build();


        repository.save(task);

        return task.getId();
    }
}
