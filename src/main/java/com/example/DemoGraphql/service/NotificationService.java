package com.example.DemoGraphql.service;

import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service component, making it eligible for dependency injection.
public class NotificationService {

    /**
     * Retrieves the count of unread notifications for a given user.
     * 
     * @param userId The ID of the user whose unread notifications are being retrieved.
     * @return The number of unread notifications for the user. Currently, this is hardcoded to 3.
     */
    public int getUnreadCount(String userId) {
        return 3; // Hardcoded value for demonstration purposes. Replace with actual logic to fetch unread notifications.
    }
}