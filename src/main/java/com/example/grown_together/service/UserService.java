package com.example.grown_together.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.example.grown_together.repository.UserRepository;

import org.springframework.cache.annotation.Cacheable;
import com.example.grown_together.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*
     * @Cacheable annotation is used to cache the result of the method.
     * The value attribute specifies the name of the cache to use.
     * The key attribute specifies the key to use for the cache entry.  
     */
    @Cacheable(value = "user", key = "#id") 
    public User getUser(String id) {
        return userRepository.findById(id);
    }

    /*
     * @CacheEvict annotation is used to evict the cache entry for the specified key.
     * The value attribute specifies the name of the cache to use.
     * The key attribute specifies the key to use for the cache entry.  
     */
    @CacheEvict(value = "user", key = "#id")
    public String updateUser(String id){
        return "User updated successfully";
    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}