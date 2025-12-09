package com.ll.restapi.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignupRequest {
    @NotBlank(message = "username 필수")
    @Size(min = 4, max = 20, message = "username은 4~20")
    private String username;

    @NotBlank(message = "password 필수")
    private String password;

    @NotBlank(message = "email 필수")
    @Email(message = "이메일 형식이 올바르지 않음")
    private String email;

    private String name;
}
