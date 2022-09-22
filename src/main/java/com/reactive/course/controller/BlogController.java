package com.reactive.course.controller;

import com.reactive.course.model.Blog;
import com.reactive.course.model.Comment;
import com.reactive.course.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public class BlogController {

    @Autowired
    private BlogService service;

    @GetMapping(value = "/getAll")
    public Flux<Blog> getAll(){
        return service.getBlogs();
    }

    @GetMapping("/getId/{id}")
    public Mono<Blog> getBlog(@PathVariable int id){
        return service.getBlogById(id);
    }

    @GetMapping("/getCat/{category}")
    public Flux<Blog> getBlogsByCategories(@PathVariable String category){
        return service.getBlogsByCategory(category);
    }

    @GetMapping("/get/blog/{id}/comments")
    public Flux<Comment> getBlogComments(@PathVariable int id){
        return service.getBlogComments(id);
    }
}
