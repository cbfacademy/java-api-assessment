package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StockKeepingSystemService {

    private final Map<UUID, Product> productMap = new HashMap<>();

    // Method to retrieve all products
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    // Method to retrieve a product by ID
    public Optional<Product> getProductById(UUID productId) {
        return Optional.ofNullable(productMap.get(productId));
    }

    // Method to add a new product
    public Product addProduct(Product product) {
        if (productMap.containsKey(product.getId())) {
            throw new IllegalArgumentException("Product with ID " + product.getId() + " already exists.");
        }
        productMap.put(product.getId(), product);
        return product;
    }

    // Method to update an existing product
    public Optional<Product> updateProduct(UUID productId, Product updatedProduct) {
        if (productMap.containsKey(productId)) {
            productMap.put(productId, updatedProduct);
            return Optional.of(updatedProduct);
        }
        return Optional.empty();
    }

    // Method to delete a product
    public boolean deleteProduct(UUID productId) {
        if (productMap.containsKey(productId)) {
            productMap.remove(productId);
            return true;
        }
        return false;
    }
}
