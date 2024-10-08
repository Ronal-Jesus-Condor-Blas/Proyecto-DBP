package com.proyecto_dbp.proyecto_dbp.auth.infrastructure.repositories;

import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
