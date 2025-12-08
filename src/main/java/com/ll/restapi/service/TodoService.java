package com.ll.restapi.service;

import com.ll.restapi.dto.request.TodoCreateRequest;
import com.ll.restapi.dto.request.TodoUpdateRequest;
import com.ll.restapi.dto.response.TodoResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface TodoService {
    TodoResponse create(TodoCreateRequest request);
    List<TodoResponse> findAll();
    TodoResponse findById(Long id);
    void deleteById(Long id);
    TodoResponse update(Long id, @Valid TodoUpdateRequest request);
}
