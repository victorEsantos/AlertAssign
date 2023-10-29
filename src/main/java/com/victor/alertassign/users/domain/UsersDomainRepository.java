package com.victor.alertassign.users.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersDomainRepository {
    Users save(Users user);

    void deleteById(UUID id);

    Optional<Users> findById(UUID id);

    List<Users> findAll();
}
