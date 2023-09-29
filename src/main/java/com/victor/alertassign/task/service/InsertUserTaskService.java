package com.victor.alertassign.task.service;

import com.victor.alertassign.task.InsertUserTaskUseCase;
import com.victor.alertassign.task.domain.Task;
import com.victor.alertassign.task.domain.TaskDomainRepository;
import com.victor.alertassign.users.domain.Users;
import com.victor.alertassign.users.domain.UsersDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsertUserTaskService implements InsertUserTaskUseCase {

    private final TaskDomainRepository repository;
    private final UsersDomainRepository usersRepository;
    @Override
    public void handle(InsertUserTaskCommand cmd) {
        Task task = repository.findById(cmd.taskId())
                .orElseThrow(() -> new RuntimeException("Task not found"));

        Users user = usersRepository.findById(cmd.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        task.addUser(user);

        repository.save(task);

    }
}
