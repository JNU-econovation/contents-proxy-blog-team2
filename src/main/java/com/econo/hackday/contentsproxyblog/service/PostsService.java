package com.econo.hackday.contentsproxyblog.service;

import com.econo.hackday.contentsproxyblog.model.Posts;
import com.econo.hackday.contentsproxyblog.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    public List<Posts> findAll() {
        return postsRepository.findAll();
    }

    public void save(Posts posts) {
        postsRepository.save(posts);
    }

    public Posts findById(Long id) {
        return postsRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
