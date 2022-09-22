package com.reactive.course.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Comment {
    @Getter
    @Setter
    private String commentContent;
}
