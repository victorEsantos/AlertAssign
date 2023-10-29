package com.victor.alertassign.users;

import java.util.List;
import java.util.UUID;

public interface GetAllUserUseCase {

    List<UserDto> handle();

    record UserDto(UUID id, String name, String email) {
    }
}
