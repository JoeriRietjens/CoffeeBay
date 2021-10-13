package com.joeri.coffeebay.Controllers;

import java.util.List;
import com.joeri.coffeebay.models.User;
import com.joeri.coffeebay.services.UserCollectionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserCollectionServices userCollectionServices;

    @GetMapping("/users")
    public List<User> all() {
        return userCollectionServices.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<User> create(@RequestBody User newUser){
        try {
            userCollectionServices.createUser(newUser);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Oopsie woopsie, we made a fucky wucky");
        } 
    }




}
