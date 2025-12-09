package com.ll.restapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequest {
    @NotBlank(message = "username은 필수")
    private String username;
    @NotBlank(message = "password은 필수")
    private String password;
}
