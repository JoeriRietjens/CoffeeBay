package com.joeri.coffeebay.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "password", nullable = false, length = 128)
    private String password;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public User(String name, String password){
       this.name = name;
       this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, firstName='%s', password='%s']",
            id, name, password);
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }

}