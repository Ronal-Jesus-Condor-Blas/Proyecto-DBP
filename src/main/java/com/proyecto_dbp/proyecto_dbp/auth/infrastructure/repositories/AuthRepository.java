package com.proyecto_dbp.proyecto_dbp.auth.infrastructure.repositories;

import com.proyecto_dbp.proyecto_dbp.auth.infrastructure.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
}
