package com.reactive.course.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class Blog {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String blogName;
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    private List<Comment> comments;
    @Getter
    @Setter
    private String category;
}
