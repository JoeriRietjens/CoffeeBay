package com.joeri.coffeebay;

import com.joeri.coffeebay.controllers.UserController;
import com.joeri.coffeebay.model.User;
import com.joeri.coffeebay.responses.AuthenticationRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired private UserController userController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(userController).isNotNull();
    }

    @Test
    public void defaultGet() throws Exception {
        assertEquals(userController.defaultGet(), "Hello!");
        assertThat(userController.defaultGet()).isEqualTo("Hello!");
    }

    @Test
    public void register() throws Exception {
        User newUser = new User("johnny", "test");
        assertNotNull(userController.create(newUser));
    }

    @Test
    public void getUsers() throws Exception {
        assertNotNull(userController.all());
    }

    @Test
    public void authenticate() throws Exception {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("johnny", "test");
       
        assertNotNull(userController.authenticate(authenticationRequest));
    }



}
