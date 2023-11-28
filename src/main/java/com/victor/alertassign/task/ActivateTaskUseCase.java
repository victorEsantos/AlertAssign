package com.victor.alertassign.task;

import org.quartz.SchedulerException;

import java.util.UUID;

public interface ActivateTaskUseCase {
    void handle(UUID taskId) throws SchedulerException;


}
