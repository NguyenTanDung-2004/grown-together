package com.example.grown_together.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grown_together.entity.Event;

public interface EventsRepository extends JpaRepository<Event, Long> {
    // Custom query methods can be defined here if needed
    // For example, find events by user ID, etc.
    
}
