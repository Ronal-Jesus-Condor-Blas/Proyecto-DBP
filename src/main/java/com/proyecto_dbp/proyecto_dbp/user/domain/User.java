package com.proyecto_dbp.proyecto_dbp.user.domain;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.followers.domain.Followers;
import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    private String profilePicture;

    private String bio;

    @Enumerated(EnumType.STRING)
    private UserType userType; // Tipo de usuario (consumidor/influencer)

    private LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    private UserStatus status;  // Estado del usuario (activo/inactivo/bloqueado)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;  // Un usuario puede crear muchos posts

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;  // Un usuario puede hacer muchos comentarios

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    private List<Followers> following;  // Un usuario sigue a otros usuarios

    @OneToMany(mappedBy = "followed", cascade = CascadeType.ALL)
    private List<Followers> followers;  // Un usuario es seguido por otros

    // Getters and Setters
}
