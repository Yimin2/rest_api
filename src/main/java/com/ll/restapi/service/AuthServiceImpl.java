package com.ll.restapi.service;

import com.ll.restapi.dto.request.LoginRequest;
import com.ll.restapi.dto.request.SignupRequest;
import com.ll.restapi.dto.response.TokenResponse;
import com.ll.restapi.dto.response.UserResponse;
import com.ll.restapi.entity.User;
import com.ll.restapi.exception.CustomException;
import com.ll.restapi.exception.ErrorCode;
import com.ll.restapi.repository.UserRepository;
import com.ll.restapi.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public UserResponse signUp(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new CustomException(ErrorCode.DUPLICATE_USERNAME);
        }
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(encodedPassword)
                .name(request.getName())
                .build();
        User saved = userRepository.save(user);
        return UserResponse.from(saved);
    }

    @Override
    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new CustomException(ErrorCode.DUPLICATE_USERNAME));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new CustomException(ErrorCode.INVALID_PASSWORD);
        }
        String accessToken = jwtProvider.createToken(user.getUsername());
        return TokenResponse.of(accessToken);
    }
}
