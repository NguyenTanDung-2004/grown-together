package com.example.DemoGraphql.service;

import org.springframework.stereotype.Service;

import com.example.DemoGraphql.model.Product;

@Service // Marks this class as a Spring service component, making it eligible for dependency injection.
public class ProductService {

    /**
     * Retrieves a product based on the given product ID.
     * 
     * @param productId The ID of the product to retrieve.
     * @return A Product object if the product ID matches a predefined value; otherwise, null.
     */
    public Product getProduct(String productId) {
        return switch (productId) {
            case "prod1" -> new Product("prod1", "Keyboard", 30.0); // Returns a Product object for "prod1".
            case "prod2" -> new Product("prod2", "Mouse", 20.0);    // Returns a Product object for "prod2".
            case "prod3" -> new Product("prod3", "USB Cable", 10.0); // Returns a Product object for "prod3".
            default -> null; // Returns null if the product ID does not match any predefined value.
        };
    }
}