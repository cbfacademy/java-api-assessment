package com.cbfacademy.apiassessment;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductIn {
    private UUID id;
    private Product product;
    private LocalDateTime entryDate;
    private Double unitPrice;
    private Integer quantity;

    public ProductIn(Product product, LocalDateTime entryDate, Double unitPrice, Integer quantity) {
        this.id = UUID.randomUUID();
        this.product = product;
        this.entryDate = entryDate;
        this.unitPrice = unitPrice;
        this.quantity = quantity;

        
        this.product.updateQuantity(this.quantity);
    }

    public ProductIn() {
    }

    public UUID getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }
}

    

