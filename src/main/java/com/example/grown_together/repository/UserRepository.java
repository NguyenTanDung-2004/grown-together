package com.example.grown_together.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grown_together.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
    
}
