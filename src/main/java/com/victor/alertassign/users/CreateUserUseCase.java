package com.victor.alertassign.users;

import java.util.UUID;

public interface CreateUserUseCase {

    UUID handle(CreateUserCommand command);

    record CreateUserCommand(String name, String email) {
    }
}
