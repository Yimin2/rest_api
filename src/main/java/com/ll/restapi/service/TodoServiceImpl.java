package com.ll.restapi.service;

import com.ll.restapi.dto.request.TodoCreateRequest;
import com.ll.restapi.dto.response.TodoResponse;
import com.ll.restapi.entity.Todo;
import com.ll.restapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    @Transactional
    public TodoResponse create(TodoCreateRequest request) {
        Todo todo = Todo.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        Todo saved = todoRepository.save(todo);

        return TodoResponse.from(saved);
     }
}
