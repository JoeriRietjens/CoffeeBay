package com.joeri.coffeebay.repository;

import com.joeri.coffeebay.model.UserOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<UserOrder, Integer>{
    
}
