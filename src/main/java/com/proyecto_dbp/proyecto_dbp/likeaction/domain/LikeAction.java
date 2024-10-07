package com.proyecto_dbp.proyecto_dbp.likeaction.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class LikeAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Clave foránea hacia User
    private User user;  // Un like es dado por un usuario

    @NotNull
    private Long contentId;  // ID del contenido que recibe el like (puede ser un post, comentario o comida)

    @NotNull
    private String contentType;  // Indica el tipo de contenido (Post, Comentario, Comida)

    private LocalDateTime likeDate;

    // Getters and Setters
}
