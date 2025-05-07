package com.example.payment.model;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    private String id;
    private String status;
    private String jsonOrder;
    private double amount;
    private String description;
}
