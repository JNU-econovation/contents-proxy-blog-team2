package com.econo.hackday.contentsproxyblog.controller;

import com.econo.hackday.contentsproxyblog.model.Posts;
import com.econo.hackday.contentsproxyblog.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostsController {

    @Autowired
    private PostsService postsService;

    @GetMapping("")
    public String start(Model model) {
        model.addAttribute("postsList", postsService.findPostsList());

        return "posts/index";
    }

    @PostMapping("")
    public String uploadForm(Posts posts) {
        postsService.savePosts(posts);

        return "redirect:/";
    }

    @GetMapping("/posts/{id}")
    public String accessPosts(@PathVariable Long id, Model model) {
        model.addAttribute("posts", postsService.findPosts(id));

        return "posts/show";
    }
}
