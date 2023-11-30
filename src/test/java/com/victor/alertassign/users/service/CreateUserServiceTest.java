package com.victor.alertassign.users.service;

import com.victor.alertassign.users.CreateUserUseCase.CreateUserCommand;
import com.victor.alertassign.users.domain.UsersDomainRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class CreateUserServiceTest {

    @Autowired
    private CreateUserService createUserService;

    @Autowired
    private UsersDomainRepository repository;

    @Test
    void deveCriarUmUsuario() {
        CreateUserCommand command = new CreateUserCommand("Victor", "victor@gmail.com");

        var uuid = createUserService.handle(command);

        var user = repository.findById(uuid);

        assertNotNull(uuid);
        assertEquals("Victor", user.get().getName());

    }


}