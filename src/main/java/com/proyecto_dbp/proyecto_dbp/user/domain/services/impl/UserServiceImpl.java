package com.proyecto_dbp.proyecto_dbp.user.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import com.proyecto_dbp.proyecto_dbp.user.domain.services.UserService;
import com.proyecto_dbp.proyecto_dbp.user.dto.UserUpdateDto;
import com.proyecto_dbp.proyecto_dbp.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Long userId) {
        return Optional.of(userId)
                .flatMap(userRepository::findById)
                .orElseThrow(() -> new RuntimeException("User nor found"));
    }

    @Override
    public void updateUser(Long userId, UserUpdateDto userUpdateDto) {
        Optional.of(userId)
                .map(this::getUserByUserId)
                .map(existUser -> updateFieldsUser(existUser,userUpdateDto))
                .map(userRepository::save)
                .orElseThrow(() -> new RuntimeException("Error couldn't update user"));
    }

    @Override
    public void deleteUser(Long userId) {
        Optional.of(userId)
                .map(this::getUserByUserId)
                .ifPresent(userRepository::delete);
    }

    private User getUserByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User nor found"));
    }

    private User updateFieldsUser(User existUser,UserUpdateDto userUpdateDto){
        existUser.setName(userUpdateDto.getName());
        existUser.setEmail(userUpdateDto.getEmail());
        existUser.setProfilePicture(userUpdateDto.getProfilePicture());
        existUser.setBiography(userUpdateDto.getBiography());
        return existUser;
    }
}
