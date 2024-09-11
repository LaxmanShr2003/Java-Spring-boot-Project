package com.example.demo.models;

import java.util.UUID;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Product {
    
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private double price;

    public Product() {
    }


    public Product(String name, String description, double price) {
        
        this.name = name;
        this.description = description;
        this.price = price;
    }

   
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
