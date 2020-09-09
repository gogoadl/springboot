package com.littlesight.springboot.web;

import com.littlesight.springboot.config.auth.LoginUser;
import com.littlesight.springboot.config.auth.dto.SessionUser;
import com.littlesight.springboot.service.PostsService;
import com.littlesight.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) // Model - 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
    {
        model.addAttribute("posts", postsService.findAllDesc());



        if(user != null)
            model.addAttribute("userName", user.getName());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
