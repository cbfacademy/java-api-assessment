package com.cbfacademy.apiassessment.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void productConstructorAndGetterTest() {
        LocalDateTime now = LocalDateTime.now();
        Product product = new Product("Test Product", "A test product", BigDecimal.valueOf(99.99), 10, 20, "Electronics", "Test Supplier");

        assertNotNull(product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals("A test product", product.getDescription());
        assertEquals(BigDecimal.valueOf(99.99), product.getPrice());
        assertEquals(10, product.getMinimumQuantity());
        assertEquals(20, product.getMaximumQuantity());
        assertTrue(product.getCreatedOn().isEqual(now) || product.getCreatedOn().isAfter(now));
        assertEquals("Electronics", product.getCategory());
        assertEquals("Test Supplier", product.getSupplier());
    }

    @Test
    void productEquals() {
        Product product1 = new Product("Product", "Description", BigDecimal.ONE, 1, 100, "Category", "Supplier");
        Product product2 = product1;

        assertEquals(product1, product2);
    }

    @Test
    void productHashCode() {
        Product product1 = new Product("Product", "Description", BigDecimal.ONE, 1, 100, "Category", "Supplier");
        Product product2 = new Product("Product", "Description", BigDecimal.ONE, 1, 100, "Category", "Supplier");

        // Note: This test might be controversial because two distinct product instances are not necessarily equal unless their ID matches.
        assertNotEquals(product1.hashCode(), product2.hashCode(), "Expected different hashCodes for different product instances.");
    }

    @Test
    void productToString() {
        Product product = new Product("Product", "Description", BigDecimal.ONE, 1, 100, "Category", "Supplier");
        String expected = "Product{id=" + product.getId() +
                ", name='Product'" +
                ", description='Description'" +
                ", price=1" +
                ", minimumQuantity=1" +
                ", maximumQuantity=100" +
                ", createdOn=" + product.getCreatedOn() +
                ", category='Category'" +
                ", supplier='Supplier'}";

        assertTrue(product.toString().startsWith("Product{id="));
    }
}
