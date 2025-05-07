package com.example.order.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.order.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderService {
    private Order order = new Order();

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    public Order createOrder() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        order = order.builder()
                .id("1")
                .userId("123")
                .productId("456")
                .status("CREATED")
                .description("This product is a test product")
                .build();

        Map<String, Object> data = new HashMap<>();
        data.put("data", order);
        data.put("event", "order.created");

        String json = objectMapper.writeValueAsString(data);

        System.out.println(json);

        // push to kafka
        kafkaTemplate.send("order-topic", json);

        return order;
    }

    @KafkaListener(topics = {"payment-topic", "inventory-topic"}, groupId = "order-group")
    public void updateOrder(String message) throws Exception {
        String cleanedMessage = message.replace("\\", "")
                                .replace("\"{", "{")
                                .replace("}\"", "}");

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> eventData = objectMapper.readValue(cleanedMessage, Map.class);

        String event = (String) eventData.get("event");

        switch (event) {
            case "payment.success":
                order.setStatus("PAID");
                String json = objectMapper.writeValueAsString(order);
                System.out.println(json);
                break;
            case "inventory.success":
                order.setStatus("DELIVERED");
                String json1 = objectMapper.writeValueAsString(order);
                System.out.println(json1);    
                break;
        
            default:
                break;
        }
    }

    
}
