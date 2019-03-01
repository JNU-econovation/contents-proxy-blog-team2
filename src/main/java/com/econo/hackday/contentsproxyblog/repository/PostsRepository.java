package com.econo.hackday.contentsproxyblog.repository;

import com.econo.hackday.contentsproxyblog.model.Posts;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository  extends CrudRepository<Posts, Long> {
}
