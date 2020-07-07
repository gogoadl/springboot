package com.littlesight.springboot.domain.posts;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Repository
public class PostsRepositoryTest {

    @Autowired(required = true)
    PostsReporitory postsReporitory;

    @After
    public void cleanup()
    { postsReporitory.deleteAll(); }

    @Test
    public void read_load()
    {

        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsReporitory.save(Posts.builder()
                             .title(title)
                             .content(content)
                             .author("gogoadl@naver.com")
                             .build());

        List<Posts> postsList = postsReporitory.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
