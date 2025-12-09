package com.ll.restapi.service;

import com.ll.restapi.dto.response.UserResponse;
import com.ll.restapi.entity.User;
import com.ll.restapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse findByUsername(String username) {
        User user = getUsernameOrThrow(username);

        return UserResponse.from(user);
    }

    private User getUsernameOrThrow(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
