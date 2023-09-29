package com.victor.alertassign.task.domain;

import java.util.Optional;
import java.util.UUID;

public interface TaskDomainRepository {
    Task save(Task task);

    Optional<Task> findById(UUID taskId);
}
