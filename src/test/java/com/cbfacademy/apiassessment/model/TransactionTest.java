package com.cbfacademy.apiassessment.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    private Transaction transaction;
    private Product product;
    private Transaction.ProductQuantity productQuantity;

    @BeforeEach
    void setUp() {
        product = new Product("Test Product", "Description", BigDecimal.valueOf(99.99), 10, 20, "Category", "Supplier");
        productQuantity = new Transaction.ProductQuantity(product, 5);
        List<Transaction.ProductQuantity> productQuantities = new ArrayList<>();
        productQuantities.add(productQuantity);

        transaction = new Transaction(TransactionType.IN, productQuantities, "Details about the transaction");
    }

    @Test
    void constructorAndGetterTest() {
        assertNotNull(transaction.getTransactionId());
        assertNotNull(transaction.getTransactionDateTime());
        assertEquals(TransactionType.IN, transaction.getTransactionType());
        assertFalse(transaction.getProductQuantities().isEmpty());
        assertEquals(1, transaction.getProductQuantities().size());
        assertEquals("Details about the transaction", transaction.getDetails());

        // Test immutability of productQuantities list
        assertThrows(UnsupportedOperationException.class, () -> 
            transaction.getProductQuantities().add(new Transaction.ProductQuantity(product, 10))
        );
    }

    @Test
    void productQuantityTest() {
        Transaction.ProductQuantity pq = transaction.getProductQuantities().get(0);
        assertEquals(product, pq.getProduct());
        assertEquals(5, pq.getQuantity());
    }
}
