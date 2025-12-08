package com.ll.restapi.dto.response;

import com.ll.restapi.entity.Todo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TodoResponse {
    private Long id;
    private String title;
    private String content;
    private boolean completed;
    private LocalDateTime createAt;

    public static TodoResponse from (Todo todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .content(todo.getContent())
                .completed(todo.isCompleted())
                .createAt(todo.getCreatedAt())
                .build();
    }
}
