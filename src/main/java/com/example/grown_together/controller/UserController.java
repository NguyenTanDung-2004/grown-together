package com.example.grown_together.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/CORS")
    public ResponseEntity<String> handleCORS() {
        return ResponseEntity.ok("CORS endpoint reached");
    }
}
