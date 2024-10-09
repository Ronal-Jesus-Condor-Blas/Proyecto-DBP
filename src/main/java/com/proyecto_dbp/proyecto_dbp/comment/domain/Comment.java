package com.proyecto_dbp.proyecto_dbp.comment.domain;

import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId; // Identificador del comentario

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Clave foránea hacia User
    private User user;  // Un comentario es hecho por un usuario

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)  // Clave foránea hacia Post
    private Post post;  // Un comentario pertenece a un post

    @Column(nullable = false, length = 500)
    private String content; // Contenido del comentario

    @Column(name = "comment_date", nullable = false)
    private LocalDateTime commentDate; // Fecha y hora en la que se creó el comentario

}