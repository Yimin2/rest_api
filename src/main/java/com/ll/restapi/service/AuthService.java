package com.ll.restapi.service;

import com.ll.restapi.dto.request.LoginRequest;
import com.ll.restapi.dto.request.SignupRequest;
import com.ll.restapi.dto.response.TokenResponse;
import com.ll.restapi.dto.response.UserResponse;

public interface AuthService {
    UserResponse signUp(SignupRequest request);
    TokenResponse login(LoginRequest request);
}
