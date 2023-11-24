package com.victor.alertassign.task.service;

import com.victor.alertassign.task.domain.TaskDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteTaskService {

    private final TaskDomainRepository repository;
    public void deleteTask(UUID id) {
        repository.deleteById(id);
    }
}
