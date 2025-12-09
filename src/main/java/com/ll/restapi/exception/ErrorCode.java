package com.ll.restapi.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    INVALID_INPUT(HttpStatus.BAD_REQUEST, "INVALID_INPUT", "잘못된 입력 값"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_ERROR", "서버 오류"),

    TODO_NOT_FOUND(HttpStatus.NOT_FOUND, "TODO_NOT_FOUND", "할일 찾을 수 없음"),

    DUPLICATE_USERNAME(HttpStatus.CONFLICT, "DUPLICATE_USERNAME", "이미 존재하는 사용자명"),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_NOT_FOUND","유저를 찾을 수 없습니다"),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "INVALID_PASSWORD","비밀번호가 일치하지 않음");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
