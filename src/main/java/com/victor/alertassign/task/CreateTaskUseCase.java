package com.victor.alertassign.task;

import com.victor.alertassign.task.domain.enums.Frequency;
import lombok.Builder;
import org.quartz.SchedulerException;

import java.util.UUID;

public interface CreateTaskUseCase {
    UUID handle(CreateTaskCommand cmd) throws SchedulerException;

    @Builder
    record CreateTaskCommand(String description, Frequency alertFrequency, Frequency rotationFrequency) {
    }
}
