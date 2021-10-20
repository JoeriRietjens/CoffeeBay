package com.joeri.coffeebay.models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Order {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private boolean ready = false;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, products='%s']",
            id, products);
    }

    public List<Product> getOrder(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public boolean isReady(){
        return ready;
    }
    
    public void setReady(boolean ready){
        this.ready = ready;
    }

}
