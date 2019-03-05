package com.econo.hackday.contentsproxyblog.service;

import com.econo.hackday.contentsproxyblog.model.Posts;
import com.econo.hackday.contentsproxyblog.repository.PostsRepository;
import com.econo.hackday.contentsproxyblog.utils.EgitUtils;
import com.econo.hackday.contentsproxyblog.utils.MarkdownRenderer;
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

    public String loadContents(Long id) throws Exception {
        String markdown = loadMarkdown(findById(id).getUrl());

        return MarkdownRenderer.parseToHtml(markdown);
    }

    private String loadMarkdown(String url) throws Exception {
        EgitUtils egitUtils = new EgitUtils();

        return egitUtils.getReadmeContents(url);
    }
}
