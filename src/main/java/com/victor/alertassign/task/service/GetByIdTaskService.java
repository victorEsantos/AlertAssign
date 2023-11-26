package com.victor.alertassign.task.service;

import com.victor.alertassign.task.GetAllTaskUseCase.TaskDto;
import com.victor.alertassign.task.domain.TaskDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetByIdTaskService {

    private final TaskDomainRepository repository;
    public TaskDto getById(UUID id) {
        return repository.findById(id, TaskDto.class);
    }
}
