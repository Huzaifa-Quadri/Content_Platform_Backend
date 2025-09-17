package com.myapp.ContentPlatform.service;

import com.myapp.ContentPlatform.model.post.Comment;
import com.myapp.ContentPlatform.payload.responses.Response;
import org.springframework.security.core.Authentication;

public interface CommentService {
    Response getCommentsByPost(Long id);
    Response getCommentById(Long id);
    Response addNewComment(Comment comment, Long id, Authentication authentication);
    Response updateComment(Comment comment, Long id, Authentication authentication);
    Response deleteComment(Long id, Authentication authentication);
}
