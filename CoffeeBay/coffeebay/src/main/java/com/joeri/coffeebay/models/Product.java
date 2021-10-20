package com.joeri.coffeebay.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, nameName='%s']",
            id, name);
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
