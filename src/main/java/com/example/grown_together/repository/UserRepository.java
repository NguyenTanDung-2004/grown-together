package com.example.grown_together.repository;


import com.example.grown_together.model.User;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    public final Map<String, User> users = new ConcurrentHashMap<>();

    public User findById(String id) {
        return users.get(id);
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }
}