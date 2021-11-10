package com.joeri.coffeebay.repository;

import com.joeri.coffeebay.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
   User getUserByName(String username);
}
