package com.victor.alertassign.users.service;

import com.victor.alertassign.users.DeleteUsersUseCase;
import com.victor.alertassign.users.domain.UsersDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserService implements DeleteUsersUseCase {

    private final UsersDomainRepository repository;

        @Override
        public ResponseEntity<String> handle(DeleteUsersCommand command) {

            repository.deleteById(command.id());

            return ResponseEntity.ok().build();
        }
}
