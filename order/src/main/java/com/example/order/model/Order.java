package com.example.order.model;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private String id;
    private String userId; 
    private String productId;
    private String status;
    private String description;
}
