package com.ll.restapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoCreateRequest {
    @NotBlank(message = "제목은 필수")
    @Size(max = 100, message = "제목 100자 이하")
    private String title;

    @Size(max = 500, message = "내용 500자 이하")
    private String content;
}
