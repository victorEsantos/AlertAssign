package com.victor.alertassign.task.repository;

import com.victor.alertassign.task.domain.Task;
import com.victor.alertassign.task.domain.TaskDomainRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TaskRepository extends TaskDomainRepository, CrudRepository<Task, UUID> {
}
