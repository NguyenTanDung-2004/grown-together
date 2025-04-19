package com.example.grown_together.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grown_together.entity.User;
import com.example.grown_together.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity createUser(@RequestBody User user){
        return ResponseEntity.ok(this.userService.createUser(user));
    }

    @GetMapping("/{userid}")
    public ResponseEntity getUser(@PathVariable(name = "userid") String userid){
        return ResponseEntity.ok(userService.getUserProfile(userid));
    }

    @PostMapping("/{userid}")
    public ResponseEntity updateUser(@PathVariable(name = "userid") String userid){
        userService.upgradeToPremium(userid);
        return ResponseEntity.ok("success");
    }
}
