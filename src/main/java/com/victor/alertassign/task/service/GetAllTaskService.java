package com.victor.alertassign.task.service;

import com.victor.alertassign.task.GetAllTaskUseCase;
import com.victor.alertassign.task.domain.TaskDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllTaskService implements GetAllTaskUseCase{

    private final TaskDomainRepository repository;

    public List<TaskDto> handle() {
        return repository.findAllProjectedBy();
    }
}
