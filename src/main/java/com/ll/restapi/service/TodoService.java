package com.ll.restapi.service;

import com.ll.restapi.dto.request.TodoCreateRequest;
import com.ll.restapi.dto.response.TodoResponse;

public interface TodoService {
    TodoResponse create(TodoCreateRequest request);
}
