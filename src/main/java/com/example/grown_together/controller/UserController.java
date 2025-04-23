package com.example.grown_together.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grown_together.model.User;
import com.example.grown_together.repository.UserRepository;
import com.example.grown_together.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userService.getUser(id);
        System.out.println("User: " + user);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id) {
        String response = userService.updateUser(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/datas")
    public ResponseEntity<String> getData() {
        System.out.println("Data: " + userRepository.users);
        return ResponseEntity.ok("Hello, this is a test data.");
    }
}