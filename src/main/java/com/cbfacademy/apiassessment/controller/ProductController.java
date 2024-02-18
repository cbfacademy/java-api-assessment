package com.cbfacademy.apiassessment.controller;

import com.cbfacademy.apiassessment.exceptions.EntityNotFoundException;
import com.cbfacademy.apiassessment.model.Product;
import com.cbfacademy.apiassessment.service.StockKeepingSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final StockKeepingSystemService stockKeepingSystemService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(StockKeepingSystemService stockKeepingSystemService) {
        this.stockKeepingSystemService = stockKeepingSystemService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        logger.info("Getting all products");
        return stockKeepingSystemService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId") UUID productId) {
        logger.info("Getting product by ID: {}", productId);
        return stockKeepingSystemService.getProductById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + productId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        logger.info("Adding a new product: {}", product.getName());
        return stockKeepingSystemService.addProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") UUID productId, @RequestBody Product product) {
        logger.info("Updating product with ID: {}", productId);
        return stockKeepingSystemService.updateProduct(productId, product)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + productId));
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("productId") UUID productId) {
        logger.info("Deleting product with ID: {}", productId);
        boolean deleted = stockKeepingSystemService.deleteProduct(productId);
        if (!deleted) {
            throw new EntityNotFoundException("Product not found with ID: " + productId);
        }
    }
}
