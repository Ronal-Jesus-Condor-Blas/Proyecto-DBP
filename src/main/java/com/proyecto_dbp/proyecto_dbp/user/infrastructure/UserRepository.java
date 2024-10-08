package com.proyecto_dbp.proyecto_dbp.user.infrastructure;

import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
