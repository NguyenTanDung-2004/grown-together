package com.example.inventory.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.inventory.model.Inventory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class InventoryService {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    @KafkaListener(topics = "payment-topic", groupId = "inventory-group")
    public Inventory createPayment(String message) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String cleanedMessage = message.replace("\\", "")
                                .replace("\"{", "{")
                                .replace("}\"", "}");
        
        Map<String, Object> eventData = objectMapper.readValue(cleanedMessage, Map.class);
        Inventory payment = Inventory.builder()
                .id("1")
                .status("inventory.success")
                .jsonPayment(objectMapper.writeValueAsString(eventData.get("data")))
                .build();

        Map<String, Object> data = new HashMap<>();
        data.put("data", payment);
        data.put("event", "inventory.success");

        String json = objectMapper.writeValueAsString(data);

        System.out.println(json);

        // push to kafka
        kafkaTemplate.send("inventory-topic", json);

        return payment;
    }

    
}
