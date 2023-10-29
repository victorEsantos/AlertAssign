package com.victor.alertassign.users.service;

import com.victor.alertassign.users.GetAllUserUseCase;
import com.victor.alertassign.users.domain.UsersDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUserService implements GetAllUserUseCase {

    private final UsersDomainRepository repository;

        @Override
        public List<UserDto> handle() {

            var users = repository.findAll();

             return users.stream().map(user -> new UserDto(user.getId(), user.getName(), user.getEmail())).toList();
        }
}
