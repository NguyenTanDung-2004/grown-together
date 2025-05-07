package com.example.payment.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.payment.model.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentService {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    @KafkaListener(topics = "order-topic", groupId = "payment-group")
    public Payment createPayment(String message) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String cleanedMessage = message.replace("\\", "")
                                .replace("\"{", "{")
                                .replace("}\"", "}");
        

        System.out.println("Received message: " + message);

        Map<String, Object> eventData = objectMapper.readValue(cleanedMessage, Map.class);
        Payment payment = Payment.builder()
                .id("1")
                .status("CREATED")
                .jsonOrder(objectMapper.writeValueAsString(eventData.get("data")))
                .amount(100.0)
                .description("This is a test payment")
                .build();

        Map<String, Object> data = new HashMap<>();
        data.put("data", payment);
        data.put("event", "payment.success");

        String json = objectMapper.writeValueAsString(data);

        System.out.println(json);

        // push to kafka
        kafkaTemplate.send("payment-topic", json);

        return payment;
    }

    
}
