package com.victor.alertassign.task.domain;

import com.victor.alertassign.task.domain.enums.Frequency;
import com.victor.alertassign.users.domain.Users;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.util.CollectionUtils.isEmpty;

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

    private UUID jobFrequencyId;

    private Frequency rotationFrequency;

    private UUID jobRotationId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "task_users",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private List<Users> users = new ArrayList<>();

    public void addUser(Users user) {
        if(isEmpty(this.users)) {
            this.users = new ArrayList<>();
            this.users.add(user);
        }

        if (!this.users.contains(user)){
            this.users.add(user);
        }
    }

    public void setCurrentUserAssignedId(UUID id) {
        this.currentUserAssignedId = id;
    }
}
