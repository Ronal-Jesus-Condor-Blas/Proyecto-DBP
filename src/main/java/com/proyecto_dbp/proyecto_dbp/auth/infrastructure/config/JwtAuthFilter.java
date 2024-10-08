package com.proyecto_dbp.proyecto_dbp.auth.infrastructure.config;

import com.proyecto_dbp.proyecto_dbp.auth.domain.JwtService;
import com.proyecto_dbp.proyecto_dbp.auth.infrastructure.repositories.AuthRepository;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final AuthRepository authRepository;

    public JwtAuthFilter(JwtService jwtService, AuthRepository authRepository) {
        this.jwtService = jwtService;
        this.authRepository = authRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional.ofNullable(request.getHeader("Authentication"))
                .filter(header -> !header.isBlank())
                .map(header -> header.substring(7))
                .map(jwtService::extractedUserId)
                .flatMap(userId -> authRepository.findById(Long.valueOf(userId)))
                .ifPresent(userDetails -> {
                    request.setAttribute("X-User-Id", userDetails.getUserId());
                    processAuthentication(request, userDetails);

                });
        filterChain.doFilter(request,response);

    }

    private void processAuthentication(HttpServletRequest request, User userDetails) {
        String jwtToken = request.getHeader("Authentication").substring(7);
        Optional.of(jwtToken)
                .filter(token -> !jwtService.isExpired(token))
                .ifPresent(token -> {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                });
    }
}
