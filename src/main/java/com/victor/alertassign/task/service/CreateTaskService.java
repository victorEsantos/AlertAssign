package com.victor.alertassign.task.service;

import com.victor.alertassign.task.CreateTaskUseCase;
import com.victor.alertassign.task.domain.Task;
import com.victor.alertassign.task.domain.TaskDomainRepository;
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
                .rotationFrequency(cmd.rotationFrequency())
                .build();

        repository.save(task);

        return task.getId();
    }
}
