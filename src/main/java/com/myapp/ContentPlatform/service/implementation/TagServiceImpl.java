package com.myapp.ContentPlatform.service.implementation;

import com.myapp.ContentPlatform.payload.responses.ContentResponse;
import com.myapp.ContentPlatform.payload.responses.Response;
import com.myapp.ContentPlatform.repository.PostRepository;
import com.myapp.ContentPlatform.repository.StoriesRepository;
import com.myapp.ContentPlatform.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final PostRepository postRepository;
    private final StoriesRepository storiesRepository;

    @Override
    public Response getPostsByTag(String tag) {
        return new ContentResponse<>(postRepository.findByTagName(tag), HttpStatus.OK);
    }

    @Override
    public Response getStoriesByTag(String tag) {
        return new ContentResponse<>(storiesRepository.findByTagName(tag), HttpStatus.OK);
    }


}
