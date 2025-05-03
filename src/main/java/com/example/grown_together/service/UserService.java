package com.example.grown_together.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.example.grown_together.entity.User;
import com.example.grown_together.repository.UserRepository;

import org.springframework.cache.annotation.Cacheable;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
