package com.example.DemoGraphql.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderWithProducts {
    private String id;
    private double total;
    private List<Product> products;
}
