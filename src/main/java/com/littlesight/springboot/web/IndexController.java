package com.littlesight.springboot.web;

import com.littlesight.springboot.config.auth.LoginUser;
import com.littlesight.springboot.config.auth.dto.SessionUser;
import com.littlesight.springboot.service.PostsService;
import com.littlesight.springboot.web.dto.PostsResponseDto;
import javassist.ClassPath;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) throws IOException // Model - 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
    {
        model.addAttribute("posts", postsService.findAllDesc());

        File imageFile = new ClassPathResource("image.png").getFile();
        model.addAttribute("logo", imageFile);
//        ClassPathResource resource = new ClassPathResource("image.png");
//        model.addAttribute("image", resource.getURL());

        if(user != null)
            model.addAttribute("userName", user.getName());

        return "index";
    }

    @GetMapping("/posts/posts")
    public String postsAll(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null)
            model.addAttribute("userName", user.getName());

        System.out.println(model.toString());
        return "index";
    }

    @GetMapping("/posts/planning")
    public String postsPlanning(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postsService.findByCategory("planning"));
        System.out.println(model.toString());

        if(user != null)
            model.addAttribute("userName", user.getName());

        return "index";
    }

    @GetMapping("/posts/mediamarketing")
    public String postsMediaMarketing(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postsService.findByCategory("mediaMarketing"));
        System.out.println(model.toString());

        if(user != null)
            model.addAttribute("userName", user.getName());

        return "index";
    }

    @GetMapping("/posts/videocontents")
    public String postsVideoContents(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postsService.findByCategory("videoContents"));
        System.out.println(model.toString());

        if(user != null)
            model.addAttribute("userName", user.getName());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
    }

    @GetMapping("/posts/detail/{id}")
    public String postsDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user)
    {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        if(user != null)
            model.addAttribute("userName", user.getName());

        return "posts-detail";
    }


    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
