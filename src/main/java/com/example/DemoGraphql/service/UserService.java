package com.example.DemoGraphql.service;

import com.example.DemoGraphql.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this class as a Spring service component, making it eligible for dependency injection.
public class UserService {

    /**
     * Retrieves a user based on the given user ID.
     * 
     * @param userId The ID of the user to retrieve.
     * @return A User object with hardcoded details for demonstration purposes.
     */
    public User getUser(String userId) {
        return new User(userId, "Alice", "alice@example.com"); // Returns a User object with hardcoded data.
    }
}