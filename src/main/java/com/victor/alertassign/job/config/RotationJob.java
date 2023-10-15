package com.victor.alertassign.job.config;

import com.victor.alertassign.task.domain.Task;
import com.victor.alertassign.task.domain.TaskDomainRepository;
import com.victor.alertassign.users.domain.Users;
import com.victor.alertassign.users.domain.UsersDomainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.UUID;

import static java.util.Objects.isNull;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class RotationJob implements Job {

    private final TaskDomainRepository taskRepository;
    private final UsersDomainRepository userRepository;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Lógica específica para jobs de tipo "Rotação" + hora de execução
        log.info("Executando job de tipo Rotação" + ZonedDateTime.now());

        if(isNull(context.getJobDetail().getJobDataMap().getString("taskId"))) return;

        UUID taskId = UUID.fromString(context.getJobDetail().getJobDataMap().getString("taskId"));

        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        UUID currentUserId = task.getCurrentUserAssignedId();
        Users currentUser = userRepository.findById(currentUserId).orElseThrow(() -> new RuntimeException("User not found"));

        Users nextUser = getNextUser(task, currentUser);

        task.setCurrentUserAssignedId(nextUser.getId());

        taskRepository.save(task);


    }

    private static Users getNextUser(Task task, Users currentUser) {
        return task
                .getUsers().stream()
                .filter(user -> user.getName().compareTo(currentUser.getName()) > 0)
                .findFirst()
                .orElse(getFirstUser(task));
    }

    private static Users getFirstUser(Task task) {
        //se nao tiver proximo usuario, retorna o primeiro da lista
        //isso quer dizer que ja foi passado por todos os usuarios
        return task.getUsers().stream().findFirst().orElseThrow(() -> new RuntimeException("User not found"));
    }
}
