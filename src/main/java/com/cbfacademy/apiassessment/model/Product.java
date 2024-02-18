package com.cbfacademy.apiassessment.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Product {
    private final UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private int minimumQuantity;
    private int maximumQuantity;
    private final LocalDateTime createdOn;
    private String category;
    private String supplier;

    public Product(String name, String description, BigDecimal price, int minimumQuantity, int maximumQuantity, String category, String supplier) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.minimumQuantity = minimumQuantity;
        this.maximumQuantity = maximumQuantity;
        this.createdOn = LocalDateTime.now();
        this.category = category;
        this.supplier = supplier;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getCategory() {
        return category;
    }

    public String getSupplier() {
        return supplier;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    // Override Object methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", minimumQuantity=" + minimumQuantity +
                ", maximumQuantity=" + maximumQuantity +
                ", createdOn=" + createdOn +
                ", category='" + category + '\'' +
                ", supplier='" + supplier + '\'' +
                '}';
    }

    public Product orElseThrow(Object object) {
        
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }
}
