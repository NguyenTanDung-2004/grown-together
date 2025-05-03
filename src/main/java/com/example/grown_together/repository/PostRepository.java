package com.example.grown_together.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grown_together.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Custom query methods can be defined here if needed
    // For example, find posts by user ID, etc.
    
}
