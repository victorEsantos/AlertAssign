package com.victor.alertassign.users.domain;

import com.victor.alertassign.task.domain.Task;
import com.victor.alertassign.task.domain.enums.Frequency;
import com.victor.alertassign.task.domain.enums.StatusTask;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @Test
    void deveCriarUmUsuario() {
        var uuid = UUID.randomUUID();
        var name = "Victor";
        var email = "victor@gmail.com";

        Users users = new Users(uuid, name, email);

        assertEquals(uuid, users.getId());
        assertEquals(name, users.getName());
        assertEquals(email, users.getEmail());

    }

    @Test
    void deveCriarUmaTask(){
        var uuid = UUID.randomUUID();
        var description = "Teste";
        var alertFrequency = Frequency.DAILY;
        var rotationFrequency = Frequency.DAILY;
        var status = StatusTask.DRAFT;

        Task task = Task.builder()
                .id(uuid)
                .description(description)
                .alertFrequency(alertFrequency)
                .rotationFrequency(rotationFrequency)
                .status(status)
                .jobFrequencyId(UUID.randomUUID())
                .jobRotationId(UUID.randomUUID())
                .currentUserAssignedId(UUID.randomUUID())
                .build();
        assertEquals(uuid, task.getId());
        assertEquals(description, task.getDescription());
        assertEquals(alertFrequency, task.getAlertFrequency());
        assertEquals(rotationFrequency, task.getRotationFrequency());
        assertEquals(status, task.getStatus());
    }

    @Test
    void deveAtivarUmaTask(){
        var uuid = UUID.randomUUID();
        var description = "Teste";
        var alertFrequency = Frequency.DAILY;
        var rotationFrequency = Frequency.DAILY;
        var status = StatusTask.DRAFT;
        UUID jobFrequencyId = UUID.randomUUID();
        UUID jobRotationId = UUID.randomUUID();

        Task task = Task.builder()
                .id(uuid)
                .description(description)
                .alertFrequency(alertFrequency)
                .rotationFrequency(rotationFrequency)
                .status(status)
                .currentUserAssignedId(UUID.randomUUID())
                .users(null)
                .build();

        task.activate(jobFrequencyId, jobRotationId);

        assertEquals(StatusTask.ACTIVE, task.getStatus());
        assertEquals(jobFrequencyId, task.getJobFrequencyId());
        assertEquals(jobRotationId, task.getJobRotationId());
    }

}