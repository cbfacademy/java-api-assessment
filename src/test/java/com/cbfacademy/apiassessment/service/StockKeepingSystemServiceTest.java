package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class StockKeepingSystemServiceTest {

    private StockKeepingSystemService service;

    @BeforeEach
    void setUp() {
        service = new StockKeepingSystemService();
    }

    @Test
    void testAddAndGetProduct() {
        Product product = new Product("Test Product", "Description", BigDecimal.valueOf(100), 10, 20, "Category", "Supplier");
        Product addedProduct = service.addProduct(product);
        UUID productId = addedProduct.getId();

        Optional<Product> retrievedProduct = service.getProductById(productId);

        assertTrue(retrievedProduct.isPresent());
        assertEquals(product.getName(), retrievedProduct.get().getName());
    }

    @Test
    void testUpdateProduct() {
        Product originalProduct = new Product("Original", "Original Description", BigDecimal.valueOf(100), 10, 20, "Category", "Supplier");
        Product addedOriginalProduct = service.addProduct(originalProduct);
        UUID productId = addedOriginalProduct.getId();

        Product updatedProduct = new Product("Updated", "Updated Description", BigDecimal.valueOf(200), 5, 15, "Updated Category", "Updated Supplier");
        service.updateProduct(productId, updatedProduct);

        Optional<Product> result = service.getProductById(productId);
        assertTrue(result.isPresent());
        assertEquals("Updated", result.get().getName());
        assertEquals(updatedProduct.getDescription(), result.get().getDescription());
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product("To Delete", "To be deleted", BigDecimal.valueOf(50), 5, 10, "Category", "Supplier");
        Product addedProduct = service.addProduct(product);
        UUID productId = addedProduct.getId();

        boolean isDeleted = service.deleteProduct(productId);
        assertTrue(isDeleted);
        assertFalse(service.getProductById(productId).isPresent());
    }

    @Test
    void testGetAllProducts() {
        service.addProduct(new Product("Product 1", "Description 1", BigDecimal.valueOf(100), 10, 20, "Category", "Supplier"));
        service.addProduct(new Product("Product 2", "Description 2", BigDecimal.valueOf(200), 20, 40, "Category", "Supplier"));

        List<Product> allProducts = service.getAllProducts();
        assertEquals(2, allProducts.size());
    }
}
