package com.example.DemoGraphql.service;

import java.util.List;
import com.example.DemoGraphql.model.*;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service component, making it eligible for dependency injection.
public class OrderService {

    /**
     * Retrieves a list of orders for a given user.
     * 
     * @param userId The ID of the user whose orders are being retrieved.
     * @return A list of orders for the user. Currently, this is hardcoded with sample data.
     */
    public List<Order> getOrdersForUser(String userId) {
        return List.of(
            new Order("order1", 99.99, List.of("prod1", "prod2")), // Sample order with two products.
            new Order("order2", 49.50, List.of("prod3"))           // Sample order with one product.
        );
    }
}