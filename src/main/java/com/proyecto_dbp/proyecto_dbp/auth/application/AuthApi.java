package com.proyecto_dbp.proyecto_dbp.auth.application;

import com.proyecto_dbp.proyecto_dbp.auth.dtos.request.LoginRequest;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.request.UserRequest;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.responses.TokenResponse;
import com.proyecto_dbp.proyecto_dbp.common.ApiPathConstants;
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
