package com.victor.alertassign.task.domain;

import com.victor.alertassign.task.GetAllTaskUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskDomainRepository {
    Task save(Task task);

    Optional<Task> findById(UUID taskId);

    //find By id projected TaskDto
    GetAllTaskUseCase.TaskDto findById(UUID taskId, Class<GetAllTaskUseCase.TaskDto> type);

    List<GetAllTaskUseCase.TaskDto> findAllProjectedBy();

    void deleteById(UUID id);
}
