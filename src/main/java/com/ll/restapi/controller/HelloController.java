package com.ll.restapi.controller;

import com.ll.restapi.dto.response.MessageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/message")
    public MessageResponse message() {
        return new MessageResponse("hello", 200);
    }

    @GetMapping("/messages")
    public List<MessageResponse> messages() {
        return List.of(new MessageResponse("hello", 200), new MessageResponse("hello2", 200), new MessageResponse("hello3", 200));
    }
}
