package com.myapp.ContentPlatform.service;

import com.myapp.ContentPlatform.model.post.Post;
import com.myapp.ContentPlatform.payload.responses.Response;
import org.springframework.security.core.Authentication;

public interface PostService {
    Response getAllPosts();
    Response getPost(Long id);
    Response addNewPost(Post post, Authentication authentication);
    Response updatePost(Post post, Long id, Authentication authentication);
    Response deletePost(Long id, Authentication authentication);
    Response likePost(Long id, Authentication authentication);
    Response repostedPost(Long id, Authentication authentication);
}
