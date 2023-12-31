package com.victor.alertassign.job.config;

import com.victor.alertassign.mail.service.EmailService;
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

import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

import static java.util.Objects.isNull;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class AlertJob implements Job {

    private final TaskDomainRepository taskRepository;
    private final UsersDomainRepository userRepository;
    private final EmailService emailService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("Job executado às " + new Date());

        if(isNull(context.getJobDetail().getJobDataMap().getString("taskId"))) return;

        UUID taskId = UUID.fromString(context.getJobDetail().getJobDataMap().getString("taskId"));

        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        UUID currentUser = task.getCurrentUserAssignedId();

        if(isNull(currentUser)) {
            //ordenar usuarios por ordem alfabetica do nome
            task.getFirstUser()
                    .ifPresent(user -> task.setCurrentUserAssignedId(user.getId()));

            if(isNull(task.getCurrentUserAssignedId())) {
                log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                log.info("Não há usuários para serem alertados");
                return;
            }
            taskRepository.save(task);
        }

        alertUser(task.getCurrentUserAssignedId(), task.getDescription());

    }

    private void alertUser(UUID currentUserAssignedId, String taskDescription) {
        Users user = userRepository.findById(currentUserAssignedId).orElseThrow(() -> new RuntimeException("User not found"));

        try {
            emailService.sendEmail(user.getEmail(), "Alerta de tarefa", "Você tem uma tarefa para ser realizada \n Descrição: " + taskDescription + "\n");
        }catch (Exception e) {
            log.error("Erro ao enviar email para o usuário " + e.getMessage());
        }

        log.info("Alertando usuário " + user.getName());
        log.info("Enviando email para " + user.getEmail());
    }
}
