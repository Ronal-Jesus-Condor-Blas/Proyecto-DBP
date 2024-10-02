package com.proyecto_dbp.proyecto_dbp.auth.infrastructure.controllers.impl;

import com.proyecto_dbp.proyecto_dbp.auth.application.services.AuthService;
import com.proyecto_dbp.proyecto_dbp.auth.domain.request.LoginRequest;
import com.proyecto_dbp.proyecto_dbp.auth.domain.request.UserRequest;
import com.proyecto_dbp.proyecto_dbp.auth.domain.responses.TokenResponse;
import com.proyecto_dbp.proyecto_dbp.auth.infrastructure.controllers.AuthApi;
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
