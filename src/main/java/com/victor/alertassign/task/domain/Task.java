package com.victor.alertassign.task.domain;

import com.victor.alertassign.task.domain.enums.Frequency;
import com.victor.alertassign.users.domain.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Task {
    @Id
    private final UUID id;

    private String description;

    private UUID currentUserAssignedId;

    private Frequency alertFrequency;

    private Frequency rotationFrequency;

    @ManyToMany
    @JoinTable(
            name = "task_users",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private List<Users> users;
}
