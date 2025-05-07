package com.example.DemoGraphql.model;

import java.util.List;


public class Dashboard {
    public User user;
    public List<OrderWithProducts> recentOrders;
    public int unreadNotifications;
    public int loyaltyPoints;

    public Dashboard(User user, List<OrderWithProducts> recentOrders, int unreadNotifications, int loyaltyPoints) {
        this.user = user;
        this.recentOrders = recentOrders;
        this.unreadNotifications = unreadNotifications;
        this.loyaltyPoints = loyaltyPoints;
    }
}