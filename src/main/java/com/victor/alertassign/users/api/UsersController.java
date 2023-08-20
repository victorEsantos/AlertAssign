package com.victor.alertassign.users.api;

import com.victor.alertassign.users.CreateUserUseCase;
import com.victor.alertassign.users.CreateUserUseCase.CreateUserCommand;
import com.victor.alertassign.users.DeleteUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private final CreateUserUseCase createUserUseCase;
    private final DeleteUsersUseCase deleteUsersUseCase;

    @PostMapping
    public UUID create(@RequestBody CreateUserCommand command) {
        return createUserUseCase.handle(command);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody DeleteUsersUseCase.DeleteUsersCommand command) {
        return deleteUsersUseCase.handle(command);
    }
}
