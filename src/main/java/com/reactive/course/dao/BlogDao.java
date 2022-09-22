package com.reactive.course.dao;

import com.reactive.course.model.Blog;
import com.reactive.course.model.Comment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BlogDao {
    Mono<Blog> getBlogById(int Id);
    Flux<Blog> getAllBlogs();
    Flux<Blog> getBlogsByCategory(String category);
    Flux<Comment> getBlogComments(int id);
}
