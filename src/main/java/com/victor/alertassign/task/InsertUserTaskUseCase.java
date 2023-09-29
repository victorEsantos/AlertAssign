package com.victor.alertassign.task;

import lombok.Builder;

import java.util.UUID;

public interface InsertUserTaskUseCase {
    void handle(InsertUserTaskCommand cmd);

    @Builder
    record InsertUserTaskCommand(UUID taskId, UUID userId) {

    }
}
