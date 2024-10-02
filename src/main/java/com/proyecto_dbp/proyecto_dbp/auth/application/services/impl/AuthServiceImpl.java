package com.proyecto_dbp.proyecto_dbp.auth.application.services.impl;

import com.proyecto_dbp.proyecto_dbp.auth.application.services.AuthService;
import com.proyecto_dbp.proyecto_dbp.auth.application.services.JwtService;
import com.proyecto_dbp.proyecto_dbp.auth.domain.request.LoginRequest;
import com.proyecto_dbp.proyecto_dbp.auth.domain.request.UserRequest;
import com.proyecto_dbp.proyecto_dbp.auth.domain.responses.TokenResponse;
import com.proyecto_dbp.proyecto_dbp.auth.infrastructure.entities.UserModel;
import com.proyecto_dbp.proyecto_dbp.auth.infrastructure.repositories.AuthRepository;
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
                .map(UserModel::getUserId)
                .map(jwtService::generateToken)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    private UserModel mapToEntity(UserRequest userRequest) {
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .name(userRequest.getName())
                .role("USER")
                .build();
    }
}
