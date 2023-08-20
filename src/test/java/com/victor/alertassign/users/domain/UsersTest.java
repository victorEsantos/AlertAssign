package com.victor.alertassign.users.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @Test
    void deveCriarUmUsuario() {
        var uuid = UUID.randomUUID();
        var name = "Victor";
        var email = "victor@gmail.com";

        Users users = new Users(uuid, name, email);

        assertEquals(uuid, users.getId());
        assertEquals(name, users.getName());
        assertEquals(email, users.getEmail());

    }

}