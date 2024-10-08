package com.proyecto_dbp.proyecto_dbp.auth.application.impl;

import com.proyecto_dbp.proyecto_dbp.auth.domain.AuthService;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.request.LoginRequest;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.request.UserRequest;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.responses.TokenResponse;
import com.proyecto_dbp.proyecto_dbp.auth.application.AuthApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<TokenResponse> createUser(UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }

    @Override
    public ResponseEntity<TokenResponse> login(LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.loginUser(loginRequest));
    }
}
