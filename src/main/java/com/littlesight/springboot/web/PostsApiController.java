package com.littlesight.springboot.web;

import com.littlesight.springboot.web.dto.PostsResponseDto;
import com.littlesight.springboot.web.dto.PostsSaveRequestDto;
import com.littlesight.springboot.service.PostsService;
import com.littlesight.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto)
    {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto)
    {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id)
    {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id")
    public PostsResponseDto findById (@PathVariable Long id)
    {
        return postsService.findById(id);
    }



}
