package com.victor.alertassign.users.domain;

import java.util.UUID;

public interface UsersDomainRepository {
    Users save(Users user);

    void deleteById(UUID id);
}
