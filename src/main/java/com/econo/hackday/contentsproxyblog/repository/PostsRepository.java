package com.econo.hackday.contentsproxyblog.repository;

import com.econo.hackday.contentsproxyblog.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository  extends JpaRepository<Posts, Long> {
}
