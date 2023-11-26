package com.victor.alertassign.task.service;

import com.victor.alertassign.job.service.DynamicJobService;
import com.victor.alertassign.task.domain.Task;
import com.victor.alertassign.task.domain.TaskDomainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteTaskService {
    private final DynamicJobService jobService;

    private final TaskDomainRepository repository;

    public void deleteTask(UUID id) {
        repository.findById(id).ifPresent(task -> {
            try {
                jobService.cancelJob(task.getJobFrequencyId().toString());
            } catch (SchedulerException e) {
                log.info("Error while deleting task: {}", e.getMessage());
            }

            try {
                jobService.cancelJob(task.getJobRotationId().toString());
            } catch (SchedulerException e) {
                log.info("Error while deleting task: {}", e.getMessage());
            }
        });

        repository.deleteById(id);
    }
}
