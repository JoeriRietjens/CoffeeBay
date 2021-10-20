package com.joeri.coffeebay.services;

import com.joeri.coffeebay.repository.UserRepository;
import java.util.List;
import com.joeri.coffeebay.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCollectionServices {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public void createUser(User user){
        repo.save(user);
    }
    
    public User getUserByName(String username){
        return repo.getUserByName(username);
    }
}
