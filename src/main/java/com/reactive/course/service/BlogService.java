package com.reactive.course.service;

import com.reactive.course.dao.BlogDao;
import com.reactive.course.model.Blog;
import com.reactive.course.model.Comment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BlogService {

    private BlogDao blogDao;

    public BlogService(BlogDao blogDao){ this.blogDao = blogDao;}

    public Mono<Blog> getBlogById(final int id){
        return blogDao.getBlogById(id);
    }

    public Flux<Blog> getBlogs(){
        return blogDao.getAllBlogs();
    }

    public Flux<Blog> getBlogsByCategory(final String category) {
        return blogDao.getBlogsByCategory(category);
    }

    public Flux<Comment> getBlogComments(final int id) {
        return blogDao.getBlogComments(id);
    }
}
