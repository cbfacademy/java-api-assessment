package com.cbfacademy.apiassessment;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductOut {
    private UUID id;
    private Product product;
    private LocalDateTime exitDate;
    private Integer quantity;

    public ProductOut(Product product, LocalDateTime exitDate, Integer quantity) {
        this.id = UUID.randomUUID();
        this.product = product;
        this.exitDate = exitDate;
        this.quantity = quantity;

        
        this.product.updateQuantity(-this.quantity);
    }

    public ProductOut() {
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
