package com.victor.alertassign.users.repository;

import com.victor.alertassign.users.domain.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UsersRepository extends CrudRepository<Users, UUID> {
}
