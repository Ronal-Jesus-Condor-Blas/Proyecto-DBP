package com.proyecto_dbp.proyecto_dbp.auth.domain.impl;

import com.proyecto_dbp.proyecto_dbp.auth.domain.AuthService;
import com.proyecto_dbp.proyecto_dbp.auth.domain.JwtService;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.request.LoginRequest;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.request.UserRequest;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.responses.TokenResponse;
import com.proyecto_dbp.proyecto_dbp.auth.infrastructure.repositories.AuthRepository;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthRepository authRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(authRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getUserId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }


    @Override
    public TokenResponse loginUser(LoginRequest loginRequest) {
        return authRepository.findByEmail(loginRequest.getEmail())
                .filter(user -> passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
                .map(User::getUserId)
                .map(jwtService::generateToken)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    private User mapToEntity(UserRequest userRequest) {
    return User.builder()
            .email(userRequest.getEmail())
            .password(userRequest.getPassword())
            .name(userRequest.getName())
            .userType(userRequest.getUserType())
            .build();
}
}
