package com.proyecto_dbp.proyecto_dbp.user.domain.services;

import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import com.proyecto_dbp.proyecto_dbp.user.dto.UserUpdateDto;

public interface UserService {
    User getUser(Long userId);
    void updateUser(Long userId, UserUpdateDto userUpdateDto);
    void deleteUser(Long userId);
}
