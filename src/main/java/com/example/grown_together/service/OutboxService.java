package com.example.grown_together.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.grown_together.entity.Outbox;
import com.example.grown_together.repository.OutboxRepository;

import jakarta.transaction.Transactional;

@Service
public class OutboxService {
    @Autowired
    private OutboxRepository outboxRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 5000) // run every 5 seconds
    public void doSomething() {
        List<Outbox> outboxes = outboxRepository.findByStatus("PENDING");
    
        if (outboxes != null && !outboxes.isEmpty()) {
            for (int i = 0; i < outboxes.size(); i++) {
                if (i % 2 == 1){
                    throw new RuntimeException("Simulated error for testing");
                }

                Outbox outbox = outboxes.get(i);
                try {
                    processSingleOutbox(outbox);
                } catch (Exception e) {
                    System.err.println("Failed to process outbox ID " + outbox.getId() + ": " + e.getMessage());
                }
            }
        } else {
            System.out.println("No pending outbox items found.");
        }
    }
    
    @Transactional(rollbackOn = Exception.class)
    public void processSingleOutbox(Outbox outbox) {
        System.out.println("Processing outbox item: " + outbox.getId());
    
        kafkaTemplate.send("outbox-topic", outbox.getData());
    
        outbox.setStatus("SENT");
        outboxRepository.save(outbox);
    }
    

}
