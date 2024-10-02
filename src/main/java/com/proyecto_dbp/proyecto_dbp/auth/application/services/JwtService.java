package com.proyecto_dbp.proyecto_dbp.auth.application.services;

import com.proyecto_dbp.proyecto_dbp.auth.domain.responses.TokenResponse;
import io.jsonwebtoken.Claims;

public interface JwtService {
    TokenResponse generateToken(Long userId);

    Claims getClaims(String token);

    boolean isExpired(String token);

    Integer extractedUserId(String token);
}
