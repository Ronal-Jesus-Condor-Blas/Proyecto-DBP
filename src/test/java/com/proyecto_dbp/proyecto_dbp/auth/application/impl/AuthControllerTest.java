package com.proyecto_dbp.proyecto_dbp.auth.application.impl;

import com.proyecto_dbp.proyecto_dbp.auth.domain.AuthService;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.request.LoginRequest;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.request.UserRequest;
import com.proyecto_dbp.proyecto_dbp.auth.dtos.responses.TokenResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Test
    void it_should_return_non_null_when_create_user() {
        Mockito.when(authService.createUser(USER_REQUEST))
                .thenReturn(TOKEN_RESPONSE);

        assertThat(authController.createUser(USER_REQUEST))
                .isNotNull();
    }

    @Test
    void it_should_return_expected_token_when_create_user() {
        Mockito.when(authService.createUser(USER_REQUEST))
                .thenReturn(TOKEN_RESPONSE);

        assertThat(authController.createUser(USER_REQUEST).getBody())
                .isEqualTo(TOKEN_RESPONSE);
    }

    @Test
    void it_should_return_expected_200_when_create_user() {
        Mockito.when(authService.createUser(USER_REQUEST))
                .thenReturn(TOKEN_RESPONSE);

        assertThat(authController.createUser(USER_REQUEST).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_non_null_when_login() {
        Mockito.when(authService.loginUser(LOGIN_REQUEST))
                .thenReturn(TOKEN_RESPONSE);

        assertThat(authController.login(LOGIN_REQUEST))
                .isNotNull();
    }

    @Test
    void it_should_return_expected_token_when_login() {
        Mockito.when(authService.loginUser(LOGIN_REQUEST))
                .thenReturn(TOKEN_RESPONSE);

        assertThat(authController.login(LOGIN_REQUEST).getBody())
                .isEqualTo(TOKEN_RESPONSE);
    }

    @Test
    void it_should_return_expected_200_when_login() {
        Mockito.when(authService.loginUser(LOGIN_REQUEST))
                .thenReturn(TOKEN_RESPONSE);

        assertThat(authController.login(LOGIN_REQUEST).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    private static final UserRequest USER_REQUEST = UserRequest.builder()
            .email("john.doe@example.com")
            .password("password")
            .build();

    private static final LoginRequest LOGIN_REQUEST = LoginRequest.builder()
            .email("john.doe@example.com")
            .password("password")
            .build();

    private static final TokenResponse TOKEN_RESPONSE = TokenResponse.builder()
            .accessToken("sample-token")
            .build();
}