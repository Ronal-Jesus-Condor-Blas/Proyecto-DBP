package com.proyecto_dbp.proyecto_dbp.auth.domain;

import com.proyecto_dbp.proyecto_dbp.auth.dtos.request.LoginRequest;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.request.UserRequest;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.responses.TokenResponse;

public interface AuthService {
    TokenResponse createUser(UserRequest userRequest);

    TokenResponse loginUser(LoginRequest loginRequest);
}
