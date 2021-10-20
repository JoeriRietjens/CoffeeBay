package com.joeri.coffeebay.repository;

import com.joeri.coffeebay.models.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
