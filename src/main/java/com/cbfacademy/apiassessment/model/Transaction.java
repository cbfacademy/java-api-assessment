package com.cbfacademy.apiassessment.model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Transaction {
    private final UUID transactionId;
    private final LocalDateTime transactionDateTime;
    private TransactionType transactionType;
    private final List<ProductQuantity> productQuantities;
    private String details;

    public Transaction(TransactionType transactionType, List<ProductQuantity> productQuantities, String details) {
        this.transactionId = UUID.randomUUID();
        this.transactionDateTime = LocalDateTime.now();
        this.transactionType = transactionType;
        this.productQuantities = Collections.unmodifiableList(productQuantities); // Make the list immutable
        this.details = details;
    }

    // Getter methods

    public UUID getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public List<ProductQuantity> getProductQuantities() {
        return productQuantities;
    }

    public String getDetails() {
        return details;
    }

    // Additional class to hold product and quantity
    public static class ProductQuantity {
        private final Product product;
        private final int quantity;

        public ProductQuantity(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}
