package com.example.DemoGraphql.service;

import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service component, making it eligible for dependency injection.
public class LoyaltyService {

    /**
     * Retrieves the loyalty points for a given user.
     * 
     * @param userId The ID of the user whose points are being retrieved.
     * @return The number of loyalty points for the user. Currently, this is hardcoded to 120.
     */
    public int getPoints(String userId) {
        return 120; // Hardcoded value for demonstration purposes. Replace with actual logic to fetch points.
    }
}