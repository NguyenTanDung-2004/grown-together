package com.example.grown_together.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.grown_together.entity.Outbox;

public interface OutboxRepository extends JpaRepository<Outbox, Integer> {
    // Custom query methods can be defined here if needed

    // getPendingOutbox
    @Query(value = "SELECT * FROM outbox WHERE status = :status LIMIT 2", nativeQuery = true)
    public List<Outbox> findByStatus(String status); // "PENDING", "SENT"
    
} 
