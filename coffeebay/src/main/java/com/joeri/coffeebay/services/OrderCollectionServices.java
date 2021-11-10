package com.joeri.coffeebay.services;

import com.joeri.coffeebay.model.UserOrder;
import com.joeri.coffeebay.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCollectionServices {
    @Autowired
    private OrderRepository repo;

    public void createOrder(UserOrder order){
        repo.save(order);
    }
}
