package com.joeri.coffeebay.services;

import com.joeri.coffeebay.models.Order;
import com.joeri.coffeebay.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCollectionServices {
    @Autowired
    private OrderRepository repo;

    public void createOrder(Order order){
        repo.save(order);
    }
}
