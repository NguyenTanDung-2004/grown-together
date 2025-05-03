package com.example.grown_together.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.example.grown_together.entity.Outbox;
import com.example.grown_together.entity.User;
import com.example.grown_together.repository.OutboxRepository;
import com.example.grown_together.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OutboxRepository outboxRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ResponseEntity<List<User>> createUser(){
        List<User> users = createListUser();

        users = userRepository.saveAll(users);

        List<Outbox> outboxes = createOutboxList(users);
        outboxRepository.saveAll(outboxes);

        return ResponseEntity.ok(users);
    }

    private List<User> createListUser(){
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            User user = new User();
            user.setUsername("User" + i);
            user.setEmail("user" + i + "@example.com");
            users.add(user);
        }

        return users;
    }

    private String convertUserToJson(User user){
        try {
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private List<Outbox> createOutboxList(List<User> users){
        List<Outbox> outboxes = new ArrayList<>();

        for (int i = 0; i < users.size(); i++){
            Outbox outbox = new Outbox();
            outbox.setId(users.get(i).getUserid());
            outbox.setStatus("PENDING");
            outbox.setData(convertUserToJson(users.get(i)));
            outboxes.add(outbox);
        }

        return outboxes;
    }
}
