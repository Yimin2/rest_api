package com.ll.restapi.service;

import com.ll.restapi.dto.request.TodoCreateRequest;
import com.ll.restapi.dto.request.TodoUpdateRequest;
import com.ll.restapi.dto.response.TodoResponse;
import com.ll.restapi.entity.Todo;
import com.ll.restapi.exception.CustomException;
import com.ll.restapi.exception.ErrorCode;
import com.ll.restapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

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

    @Override
    public List<TodoResponse> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponse::from)
                .toList();
    }

    @Override
    public TodoResponse findById(Long id) {
        Todo todo = getTodoOrThrow(id);
        return TodoResponse.from(todo);
    }

    private Todo getTodoOrThrow(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.TODO_NOT_FOUND));
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        if(!todoRepository.existsById(id)) {
            throw new CustomException(ErrorCode.TODO_NOT_FOUND);
        }
        todoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public TodoResponse update(Long id, TodoUpdateRequest request) {
        Todo todo = getTodoOrThrow(id);
        todo.update(request.getTitle(), request.getContent());

        return TodoResponse.from(todo);
    }
}
