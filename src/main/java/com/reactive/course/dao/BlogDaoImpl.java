package com.reactive.course.dao;

import com.reactive.course.model.Blog;
import com.reactive.course.model.Comment;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.*;

@Component
public class BlogDaoImpl implements BlogDao{

    private static List<Blog> blogList = new ArrayList<>();

    static {
        blogList.add(new Blog(1, "Blog 1", "Content 1",
                Arrays.asList(new Comment("Comment 1 for Blog 1")), "Categeroy 1"));
        blogList.add(new Blog(2, "Blog 2", "Content 2",
                Arrays.asList(new Comment("Comment 1 for Blog 2")), "Categeroy 2"));
        blogList.add(new Blog(3, "Blog 3", "Content 3",
                Arrays.asList(new Comment("Comment 1 for Blog 3")), "Categeroy 1"));
        blogList.add(new Blog(4, "Blog 4", "Content 4",
                Arrays.asList(new Comment("Comment 1 for Blog 4")), "Categeroy 3"));
        blogList.add(new Blog(5, "Blog 5", "Content 5",
                Arrays.asList(new Comment("Comment 1 for Blog 5")), "Categeroy 3"));
        blogList.add(new Blog(6, "Blog 6", "Content 6",
                Arrays.asList(new Comment("Comment 1 for Blog 6")), "Categeroy 2"));
        blogList.add(new Blog(7, "Blog 7", "Content 7",
                Arrays.asList(new Comment("Comment 1 for Blog 7")), "Categeroy 4"));
        blogList.add(new Blog(8, "Blog 8", "Content 8",
                Arrays.asList(new Comment("Comment 1 for Blog 8")), "Categeroy 3"));
        blogList.add(new Blog(9, "Blog 9", "Content 9",
                Arrays.asList(new Comment("Comment 1 for Blog 9")), "Categeroy 1"));
        blogList.add(new Blog(10, "Blog 10", "Content 10",
                Arrays.asList(new Comment("Comment 1 for Blog 10")), "Categeroy 1"));

    }

    @Override
    public Mono<Blog> getBlogById(final int Id) {
        return Flux.fromIterable(blogList)
                .filter(blog -> Id == blog.getId())
                .next();
    }

    @Override
    public Flux<Blog> getAllBlogs() {
        return Flux.fromIterable(blogList)
                .delayElements(Duration.ofSeconds(2));
    }

    @Override
    public Flux<Blog> getBlogsByCategory(final String category) {
        return Flux.fromIterable(blogList)
                .filter(blog -> category.equalsIgnoreCase(blog.getCategory()))
                .delayElements(Duration.ofSeconds(2));
    }

    @Override
    public Flux<Comment> getBlogComments(final int id) {
        return getBlogById(id)
                .flatMapIterable(blog -> blog.getComments())
                .delayElements(Duration.ofSeconds(2));
    }


}
