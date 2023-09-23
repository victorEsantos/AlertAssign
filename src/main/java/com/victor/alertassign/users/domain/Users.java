package com.victor.alertassign.users.domain;

import com.victor.alertassign.task.domain.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Users {

    @Id
    private final UUID id;
    private final String name;
    private final String email;

    @ManyToMany
    private List<Task> tasks;
}
