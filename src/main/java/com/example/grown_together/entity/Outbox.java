package com.example.grown_together.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "outbox")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Outbox {
    @Id
    private Integer id;
    private String data;
    private String status; // "PENDING", "SENT"
}
