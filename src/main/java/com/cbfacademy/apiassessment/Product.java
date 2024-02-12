package com.cbfacademy.apiassessment;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product {
    private UUID Id;
    private String name;
    private String description;
    private Integer quantity; 
    private Integer minimumQuantity;
    private Integer maximumQuantity;
    private LocalDateTime createdOn;

    public Product(String name, String description, Integer minimumQuantity, Integer maximumQuantity) {
        this.name = name;
        this.description = description;
        this.minimumQuantity = minimumQuantity;
        this.maximumQuantity = maximumQuantity;
        this.createdOn = LocalDateTime.now();
        this.quantity = 0; 
    }

    public Product() {
    }

    public Product(UUID id) {
        this.Id = id;
    }

    public UUID getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    
    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }
}
