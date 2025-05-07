package com.example.DemoGraphql.resolver;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.DemoGraphql.model.*;
import com.example.DemoGraphql.service.*;

@Controller // Marks this class as a Spring component and a GraphQL resolver.
public class DashboardQueryResolver {

    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;
    private final NotificationService notificationService;
    private final LoyaltyService loyaltyService;

    // Constructor for dependency injection of services.
    public DashboardQueryResolver(
        UserService userService,
        OrderService orderService,
        ProductService productService,
        NotificationService notificationService,
        LoyaltyService loyaltyService
    ) {
        this.userService = userService;
        this.orderService = orderService;
        this.productService = productService;
        this.notificationService = notificationService;
        this.loyaltyService = loyaltyService;
    }

    @QueryMapping // Maps this method to a GraphQL query named "dashboard".
    public Dashboard dashboard(@Argument String userId) {
        System.out.println("DASHBOARD QUERY RECEIVED FOR USER: " + userId);

        // Fetch user details using UserService.
        User user = userService.getUser(userId);

        // Fetch orders for the user and map them to include product details.
        List<OrderWithProducts> orders = orderService.getOrdersForUser(userId).stream().map(order -> {
            List<Product> products = order.getProductIds().stream()
                .map(productService::getProduct) // Fetch product details for each product ID.
                .collect(Collectors.toList());
            return new OrderWithProducts(order.getId(), order.getTotal(), products);
        }).toList();

        // Construct and return the Dashboard object with user, orders, unread notifications, and loyalty points.
        return new Dashboard(
            user,
            orders,
            notificationService.getUnreadCount(userId), // Fetch unread notification count.
            loyaltyService.getPoints(userId)            // Fetch loyalty points.
        );
    }
}