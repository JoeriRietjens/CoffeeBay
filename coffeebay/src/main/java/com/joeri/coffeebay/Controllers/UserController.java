package com.joeri.coffeebay.controllers;

import java.nio.file.AccessDeniedException;
import java.util.List;

import com.joeri.coffeebay.model.User;
import com.joeri.coffeebay.responses.AuthenticationRequest;
import com.joeri.coffeebay.responses.AuthenticationResponse;
import com.joeri.coffeebay.responses.RegisterResponse;
import com.joeri.coffeebay.services.UserCollectionServices;
import com.joeri.coffeebay.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserCollectionServices userCollectionServices;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/users")
    public List<User> all() {
        return userCollectionServices.findAll();
    }

    @PostMapping("/register") 
    public ResponseEntity<RegisterResponse> create(@RequestBody User newUser) {
        try {

            System.out.println(newUser.toString());

            RegisterResponse registerResponse = new RegisterResponse();
            userCollectionServices.createUser(newUser);
            registerResponse.setIsSucces(true);
            
            return ResponseEntity.ok(registerResponse);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } 
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        System.out.println(authenticationRequest);
        try{    
            userCollectionServices.login(authenticationRequest);   
        } catch (AccessDeniedException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        final User user = userCollectionServices.findByUserName(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(user);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping(value="/hi")
    public String defaultGet() {
        return "Hello!";
    }
    
}
