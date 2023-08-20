package com.victor.alertassign.users;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface DeleteUsersUseCase {

    ResponseEntity<String> handle(DeleteUsersCommand command);

    record DeleteUsersCommand(UUID id) {
    }
}
