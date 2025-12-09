package com.ll.restapi.service;

import com.ll.restapi.dto.response.UserResponse;

public interface UserService {
    UserResponse findByUsername(String username);
}
