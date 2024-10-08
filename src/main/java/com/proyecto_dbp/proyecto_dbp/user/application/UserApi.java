package com.proyecto_dbp.proyecto_dbp.user.application;

import com.proyecto_dbp.proyecto_dbp.common.ApiPathConstants;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import com.proyecto_dbp.proyecto_dbp.user.dto.UserUpdateDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.USER_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public interface UserApi {
    @GetMapping
    ResponseEntity<User> getUser(
            @RequestAttribute("X-User-Id") Long userId
    );

    @PutMapping
    ResponseEntity<Void> updateUser(
            @RequestAttribute("X-User-Id") Long userId,
            @Valid @RequestBody UserUpdateDto userUpdateDto
    );

    @DeleteMapping
    ResponseEntity<Void> deleteUser(
            @RequestAttribute("X-User-Id") Long userId
    );
}
