package com.littlesight.springboot.web.dto;

import com.littlesight.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String category;
    private String modifiedDate;

    public PostsListResponseDto(Posts entity)
    {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.category = entity.getCategory();
        this.modifiedDate = entity.getModifiedTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
