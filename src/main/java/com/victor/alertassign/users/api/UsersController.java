package com.victor.alertassign.users.api;

import com.victor.alertassign.users.CreateUserUseCase;
import com.victor.alertassign.users.CreateUserUseCase.CreateUserCommand;
import com.victor.alertassign.users.DeleteUsersUseCase;
import com.victor.alertassign.users.GetAllUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.victor.alertassign.users.GetAllUserUseCase.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private final CreateUserUseCase createUserUseCase;
    private final DeleteUsersUseCase deleteUsersUseCase;
    private final GetAllUserUseCase getAllUserUseCase;

    @PostMapping
    public UUID create(@RequestBody CreateUserCommand command) {
        return createUserUseCase.handle(command);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody DeleteUsersUseCase.DeleteUsersCommand command) {
        return deleteUsersUseCase.handle(command);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(getAllUserUseCase.handle());
    }
}
