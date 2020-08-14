package com.littlesight.springboot.service;

import com.littlesight.springboot.domain.posts.Posts;
import com.littlesight.springboot.domain.posts.PostsRepository;
import com.littlesight.springboot.web.dto.PostsResponseDto;
import com.littlesight.springboot.web.dto.PostsSaveRequestDto;
import com.littlesight.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 만들어 줌
@Service
public class PostsService {
    private final PostsRepository postsReporitory;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        return postsReporitory.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto)
    {
        Posts posts = postsReporitory.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id)
    {
        Posts entity = postsReporitory.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
