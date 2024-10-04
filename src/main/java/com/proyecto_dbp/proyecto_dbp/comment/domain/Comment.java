package com.proyecto_dbp.proyecto_dbp.comment.domain;

import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(name = "fecha_comentario", nullable = false)
    private LocalDateTime commentDate;

    // Constructor, Getters y Setters generados automáticamente por Lombok (@Data)
}

