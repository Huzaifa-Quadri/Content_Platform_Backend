package com.myapp.ContentPlatform.service;

import com.myapp.ContentPlatform.model.post.Stories;
import com.myapp.ContentPlatform.payload.responses.Response;
import org.springframework.security.core.Authentication;

public interface StoriesService {
    Response getAllStories();
    Response getStories(Long id);
    Response addNewStories(Stories stories, Authentication authentication);
    Response deleteStories(Long id, Authentication authentication);
    Response likeStories(Long id, Authentication authentication);
    Response repostedStories(Long id, Authentication authentication);
}