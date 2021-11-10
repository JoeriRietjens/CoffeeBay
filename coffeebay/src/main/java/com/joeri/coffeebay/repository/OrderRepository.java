package com.joeri.coffeebay.repository;

import com.joeri.coffeebay.model.UserOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<UserOrder, Integer>{
    
}
