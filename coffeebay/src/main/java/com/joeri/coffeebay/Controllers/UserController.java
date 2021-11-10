package com.joeri.coffeebay.controllers;

import java.security.AccessControlException;
import java.util.List;

import com.joeri.coffeebay.model.User;
import com.joeri.coffeebay.responses.AuthenticationRequest;
import com.joeri.coffeebay.responses.LoginResponse;
import com.joeri.coffeebay.responses.RegisterResponse;
import com.joeri.coffeebay.services.UserCollectionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserCollectionServices userCollectionServices;

    @GetMapping("/users")
    public List<User> all() {
        return userCollectionServices.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity <RegisterResponse> create(@RequestBody User newUser){
        try {
            System.out.println(newUser);
            RegisterResponse registerResponse = new RegisterResponse();
            userCollectionServices.createUser(newUser);
            registerResponse.setIsSucces(true);
            
            return ResponseEntity.ok(registerResponse);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } 
    }

    @PostMapping("/authenticate")
    public ResponseEntity <LoginResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        try{
            
            userCollectionServices.login(authenticationRequest);

            LoginResponse loginResponse = new LoginResponse();
            return ResponseEntity.ok(loginResponse);
        } catch (AccessControlException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something went wrong");
        }
    }

    @GetMapping(value="/hi")
    public String defaultGet() {
        return "Hello!";
    }
    
}
