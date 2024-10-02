package com.proyecto_dbp.proyecto_dbp.auth.application.services;

import com.proyecto_dbp.proyecto_dbp.auth.domain.request.LoginRequest;
import com.proyecto_dbp.proyecto_dbp.auth.domain.request.UserRequest;
import com.proyecto_dbp.proyecto_dbp.auth.domain.responses.TokenResponse;

public interface AuthService {
    TokenResponse createUser(UserRequest userRequest);

    TokenResponse loginUser(LoginRequest loginRequest);
}
