package com.littlesight.springboot.web.dto;

import com.littlesight.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private String lastModifiedDate;
    private String category;

    public PostsResponseDto(Posts entity)
    {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.lastModifiedDate = entity.getModifiedTime().toString();
        this.category = entity.getCategory();
    }

}
