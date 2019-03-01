package com.econo.hackday.contentsproxyblog.controller;

import com.econo.hackday.contentsproxyblog.model.Posts;
import com.econo.hackday.contentsproxyblog.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostsController {

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping("")
    public String start(Model model) {
        model.addAttribute("postsList", postsRepository.findAll());

        return "/index";
    }

    @PostMapping("/posts")
    public String uploadForm(Posts posts) {
        postsRepository.save(posts);

        return "redirect:/";
    }

    @GetMapping("/posts/{id}")
    public String accessPosts(@PathVariable Long id, Model model) {
        model.addAttribute("posts", postsRepository.findById(id));

        return "posts/show";
    }
}
