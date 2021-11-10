package com.joeri.coffeebay.services;

import com.joeri.coffeebay.model.User;
import com.joeri.coffeebay.repository.UserRepository;
import com.joeri.coffeebay.responses.AuthenticationRequest;
import com.joeri.coffeebay.util.PasswordHasher;
import com.joeri.coffeebay.util.PasswordValidator;

import java.nio.file.AccessDeniedException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserCollectionServices {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public void createUser(User user) throws NoSuchAlgorithmException{

        if(repo.getUserByName(user.getName()) != null){
            return;
        }
        String hashedPassword = PasswordHasher.HashPassword(user.getPassword());
        user.setPassword(hashedPassword);

        repo.save(user);
    }
    
    public User getUserByName(String username){
        return repo.getUserByName(username);
    }

    public User login(AuthenticationRequest authenticationRequest) throws AccessDeniedException, NoSuchAlgorithmException{

        if(repo.getUserByName(authenticationRequest.getUsername()) == null){
            throw new UsernameNotFoundException("user" + authenticationRequest.getUsername() + "not found");
        }

        User storedUser = repo.getUserByName(authenticationRequest.getUsername());

        if(PasswordValidator.validatePassword(storedUser.getPassword(), authenticationRequest.getPassword())){
            User user = new User(storedUser.getName(), storedUser.getPassword());
            return user;
        }        
        throw new AccessDeniedException("Access Denied");
    }
}
