package com.victor.alertassign.users.service;

import com.victor.alertassign.users.DeleteUsersUseCase;
import com.victor.alertassign.users.domain.Users;
import com.victor.alertassign.users.domain.UsersDomainRepository;
import com.victor.alertassign.users.factory.UsersFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
class DeleteUserServiceTest {

    @Autowired
    private DeleteUserService deleteUserService;

    @Autowired
    private UsersDomainRepository repository;

    @Test
    void deveDeletarUmUsuario() {
        Users user = UsersFactory.buildAUser();

        repository.save(user);

        assertNotNull(user.getId());

        deleteUserService.handle(new DeleteUsersUseCase.DeleteUsersCommand(user.getId()));

        var deletedUser = repository.findById(user.getId());

        assertTrue(deletedUser.isEmpty());

    }


}