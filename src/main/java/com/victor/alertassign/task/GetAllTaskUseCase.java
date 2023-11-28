package com.victor.alertassign.task;

import com.victor.alertassign.task.domain.enums.Frequency;
import com.victor.alertassign.task.domain.enums.StatusTask;

import java.util.List;
import java.util.UUID;

public interface GetAllTaskUseCase {
    List<TaskDto> handle();


    interface TaskDto {
        UUID getId();

        String getDescription();

        Frequency getAlertFrequency();

        Frequency getRotationFrequency();

        List<UserDto> getUsers();

        StatusTask getStatus();

    }

    interface UserDto {
        UUID getId();

        String getName();

        String getEmail();
    }

}
