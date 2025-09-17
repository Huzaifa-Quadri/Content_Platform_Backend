package com.myapp.ContentPlatform.controller;

import com.myapp.ContentPlatform.payload.responses.Response;
import com.myapp.ContentPlatform.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping("/{tagName}/posts")
    public ResponseEntity<Response> getPostsByTag(@PathVariable String tagName) {
        Response response = tagService.getPostsByTag(tagName);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("/{tagName}/stories")
    public ResponseEntity<Response> getStoriesByTag(@PathVariable String tagName) {
        Response response = tagService.getStoriesByTag(tagName);
        return new ResponseEntity<>(response, response.getStatus());
    }
}

