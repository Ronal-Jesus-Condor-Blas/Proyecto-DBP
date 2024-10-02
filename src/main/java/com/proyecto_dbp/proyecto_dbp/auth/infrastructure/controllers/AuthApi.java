package com.proyecto_dbp.proyecto_dbp.auth.infrastructure.controllers;

import com.proyecto_dbp.proyecto_dbp.auth.domain.constants.ApiPathConstants;
import com.proyecto_dbp.proyecto_dbp.auth.domain.request.LoginRequest;
import com.proyecto_dbp.proyecto_dbp.auth.domain.request.UserRequest;
import com.proyecto_dbp.proyecto_dbp.auth.domain.responses.TokenResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The interface Auth api.
 */
@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface AuthApi {
    /**
     * Create user response entity.
     *
     * @param userRequest the user request
     * @return the response entity
     */
    @PostMapping("/register")
    ResponseEntity<TokenResponse> createUser(@RequestBody @Valid UserRequest userRequest);

    /**
     * Login response entity.
     *
     * @param loginRequest the login request
     * @return the response entity
     */
    @PostMapping("/login")
    ResponseEntity<TokenResponse> login(@RequestBody @Valid LoginRequest loginRequest);
}
