package com.victor.alertassign.task.domain;

import com.victor.alertassign.task.domain.enums.Frequency;
import lombok.Builder;

import java.util.UUID;

public interface CreateTaskUseCase {
    UUID handle(CreateTaskCommand cmd);

    @Builder
    record CreateTaskCommand(String description, Frequency alertFrequency, Frequency rotationFrequency) {
    }
}
