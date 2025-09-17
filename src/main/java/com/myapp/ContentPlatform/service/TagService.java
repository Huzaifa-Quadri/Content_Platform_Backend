package com.myapp.ContentPlatform.service;

import com.myapp.ContentPlatform.payload.responses.Response;

public interface TagService {
    Response getStoriesByTag(String tag);
    Response getPostsByTag(String tag);
}
