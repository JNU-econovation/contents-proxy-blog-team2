package com.econo.hackday.contentsproxyblog.service;

import com.econo.hackday.contentsproxyblog.model.Posts;
import com.econo.hackday.contentsproxyblog.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    public Iterable<Posts> findPostsList() {
        return postsRepository.findAll();
    }

    public void savePosts(Posts posts) {
        postsRepository.save(posts);
    }

    public Posts findPosts(Long id) {
        return postsRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
