package com.example.grown_together.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grown_together.dto.RequestCreatePost;
import com.example.grown_together.entity.Post;
import com.example.grown_together.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    public Post createOrUpdate(@RequestBody RequestCreatePost request){
        
        return postService.createOrUpdate(request);

        
    }
}
