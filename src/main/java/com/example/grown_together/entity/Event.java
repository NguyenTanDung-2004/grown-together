package com.example.grown_together.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "events")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {
    @Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String entityname;
    private String eventname;
    private String status;
    private Long createdbyuserid;
    private String createddate;
    private String data;
}
