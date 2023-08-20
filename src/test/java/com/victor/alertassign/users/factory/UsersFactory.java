package com.victor.alertassign.users.factory;

import com.victor.alertassign.users.domain.Users;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class UsersFactory {

    public Users buildAUser() {
        return new Users(UUID.randomUUID(), "Victor", "victor@gmail.com");
    }
}
