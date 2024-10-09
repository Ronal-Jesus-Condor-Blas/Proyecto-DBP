package com.proyecto_dbp.proyecto_dbp.user.application.impl;

import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import com.proyecto_dbp.proyecto_dbp.user.domain.UserType;
import com.proyecto_dbp.proyecto_dbp.user.domain.services.UserService;
import com.proyecto_dbp.proyecto_dbp.user.dto.UserUpdateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Test
    void it_should_return_non_null_when_get_user() {
        Mockito.when(userService.getUser(USER_ID))
                        .thenReturn(USER_RETURNED);

        assertThat(userController.getUser(USER_ID))
                .isNotNull();
    }

    @Test
    void it_should_return_expected_user_when_get_user() {
        Mockito.when(userService.getUser(USER_ID))
                .thenReturn(USER_RETURNED);

        assertThat(userController.getUser(USER_ID).getBody())
                .isEqualTo(USER_RETURNED);
    }

    @Test
    void it_should_return_expected_200_when_get_user() {
        Mockito.when(userService.getUser(USER_ID))
                .thenReturn(USER_RETURNED);

        assertThat(userController.getUser(USER_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_no_content_when_update_user() {
        Mockito.doNothing().when(userService).updateUser(USER_ID, USER_UPDATE_DTO);

        assertThat(userController.updateUser(USER_ID, USER_UPDATE_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Test
    void it_should_return_no_content_when_delete_user() {
        Mockito.doNothing().when(userService).deleteUser(USER_ID);

        assertThat(userController.deleteUser(USER_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private static final Long USER_ID = 1L;
    private static final User USER_RETURNED = User.builder()
            .userId(USER_ID)
            .name("John Doe")
            .email("john.doe@example.com")
            .password("password")
            .profilePicture("http://example.com/profile.jpg")
            .biography("Sample biography")
            .userType(UserType.CONSUMER)
            .registerDate(LocalDateTime.now())
            .build();

    private static final UserUpdateDto USER_UPDATE_DTO = UserUpdateDto.builder()
            .name("John Doe Updated")
            .email("john.doe.updated@example.com")
            .biography("Updated biography")
            .build();

}