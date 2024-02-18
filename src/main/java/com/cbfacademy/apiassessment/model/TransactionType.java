package com.cbfacademy.apiassessment.model;

public enum TransactionType {
    IN("Product received"),
    OUT("Product sold"),
    TRANSFER("Product transferred between locations");

    private final String description;

    TransactionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // Example utility method to parse string values into TransactionType
    public static TransactionType fromString(String text) {
        for (TransactionType b : TransactionType.values()) {
            if (b.description.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
