package com.victor.alertassign.users.domain;

import com.victor.alertassign.task.domain.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Users {

    @Id
    private final UUID id;
    private String name;
    private String email;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Task> tasks = new ArrayList<>();

    public Users(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tasks = new ArrayList<>();
    }
}
