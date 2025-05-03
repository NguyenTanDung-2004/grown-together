package com.example.grown_together.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grown_together.dto.RequestCreatePost;
import com.example.grown_together.entity.Event;
import com.example.grown_together.entity.Post;
import com.example.grown_together.enums.EnumPostEvents;
import com.example.grown_together.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createOrUpdate(RequestCreatePost request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCreatedbyuserid(request.getCreatedByUserId());
        post.setModifieddate(new Date());
        post.setStatus(request.getStatus());

        postRepository.save(post);

        EnumPostEvents enumevent = EnumPostEvents.getById(request.getEventid());

        Event event = new Event();
        event.setEntityname("post");
        event.setEventname(enumevent.getValue());
        event.setStatus("ACTIVE");

        if (event.getEventname().equals("POST_CREATED")) {
            post.setCreateddate(new Date());
            event.setCreatedbyuserid(request.getCreatedByUserId());
        } 
        else{
            event.setCreatedbyuserid(request.getModifiedByUserId());
        }

        return post;
    }
}
