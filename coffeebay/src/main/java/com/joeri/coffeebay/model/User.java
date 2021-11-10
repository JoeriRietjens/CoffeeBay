package com.joeri.coffeebay.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<UserOrder> orders = new ArrayList<>();

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

    public void setPassword(String password){
        this.password = password;
    }
    
    public void addOrder(UserOrder order){
        orders.add(order);
    }

    public void removeOrder(UserOrder order){
        orders.remove(order);
    }

}