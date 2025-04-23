package com.example.grown_together.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements java.io.Serializable {
    private String id;
    private String name;
}