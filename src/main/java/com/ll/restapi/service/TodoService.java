package com.ll.restapi.service;

import com.ll.restapi.dto.request.TodoCreateRequest;
import com.ll.restapi.dto.response.TodoResponse;

import java.util.List;

public interface TodoService {
    TodoResponse create(TodoCreateRequest request);
    List<TodoResponse> findAll();
    TodoResponse findById(Long id);
}
