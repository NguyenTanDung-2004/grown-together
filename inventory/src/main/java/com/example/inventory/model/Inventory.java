package com.example.inventory.model;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory {
    private String id;
    private String status;
    private String jsonPayment;
}
