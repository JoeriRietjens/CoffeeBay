package com.joeri.coffeebay.controllers;

import com.joeri.coffeebay.model.UserOrder;
import com.joeri.coffeebay.services.OrderCollectionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("order")
public class OrderController {
    
    @Autowired
    private OrderCollectionServices orderCollectionServices;

    @PostMapping("/newOrder")
    public ResponseEntity<UserOrder> create(@RequestBody UserOrder order){
        try {
            orderCollectionServices.createOrder(order);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Oopsie woopsie, we made a fucky wucky");
        } 
    }

}
