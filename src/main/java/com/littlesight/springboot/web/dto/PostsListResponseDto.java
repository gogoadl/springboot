package com.littlesight.springboot.web.dto;

import com.littlesight.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String category;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entitiy)
    {
        this.id = entitiy.getId();
        this.title = entitiy.getTitle();
        this.author = entitiy.getAuthor();
        this.category = entitiy.getCategory();
        this.modifiedDate = entitiy.getModifiedTime();
    }
}
