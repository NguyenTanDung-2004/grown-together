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

    @Cacheable("userProfile")
    public User getUserProfile(String userId) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Fetching from DB for user " + userId);
        return userRepository.findById(userId).orElse(null);
    }

    @CacheEvict(value = "userProfile", key = "#userId")
    public void upgradeToPremium(String userId) {
        userRepository.findById(userId).ifPresent(user -> {
            if (user.getIsprenium() == false){
                user.setIsprenium(true);
            }
            else{
                user.setIsprenium(false);
            }
            
            userRepository.save(user);
        });
    }

    public User createUser(User user){
        user = this.userRepository.save(user);
        return user; 
    }
}
