package com.joeri.coffeebay.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @JsonProperty("name")
    @Column(name = "name", nullable = false)
    private String name;

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, name='%s']",
            id, name);
    }

    // public Long getId(){
    //     return id;
    // }

    // public String getName(){
    //     return name;
    // }

    // public void setName(String name){
    //     this.name = name;
    // }

    // public boolean getIsReady(){
    //     return isReady;
    // }

    // public void setIsReady(boolean isReady){
    //    this.isReady = isReady;
    // }
}