package com.victor.alertassign.users.service;

import com.victor.alertassign.users.CreateUserUseCase;
import com.victor.alertassign.users.domain.Users;
import com.victor.alertassign.users.domain.UsersDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final UsersDomainRepository repository;

        @Override
        public UUID handle(CreateUserCommand command) {
            Users user = new Users(UUID.randomUUID(), command.name(), command.email(), null);

            repository.save(user);

            return user.getId();
        }
}
