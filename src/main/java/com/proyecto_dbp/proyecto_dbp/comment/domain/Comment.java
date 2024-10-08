package com.proyecto_dbp.proyecto_dbp.comment.domain;

import java.time.LocalDateTime;

import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Entity
@Data  // Lombok genera automáticamente los getters, setters, toString, equals, y hashCode
@Builder
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId; // Identificador único del comentario

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Clave foránea hacia User
    private Integer user;  // Un comentario es hecho por un usuario

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)  // Clave foránea hacia Post
    private Post post;  // Un comentario pertenece a un post

    @NotNull
    private String content; // Contenido del comentario

    private LocalDateTime commentDate;  // Fecha y hora en la que se hizo el comentario
}
