package com.proyecto_dbp.proyecto_dbp.auth.domain.impl;

import com.proyecto_dbp.proyecto_dbp.auth.infrastructure.repositories.AuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {
    private final AuthRepository authRepository;

    public UserDetailsImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return authRepository.findByEmail(name)
                .orElseThrow(() -> new RuntimeException("UserDetailsService user not found"));
    }
}
