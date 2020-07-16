package com.littlesight.springboot.service;

import com.littlesight.springboot.domain.posts.PostsReporitory;
import com.littlesight.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsReporitory postsReporitory;

    @Transactional
    public long save(PostsSaveRequestDto requestDto)
    {
        return postsReporitory.save(requestDto.toEntity()).getId();
    }
}
