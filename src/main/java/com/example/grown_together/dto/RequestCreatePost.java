package com.example.grown_together.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreatePost {
    private String title;
    private String content;
    private Long createdByUserId;
    private Long modifiedByUserId;
    private String status;
    private Integer eventid;
}
