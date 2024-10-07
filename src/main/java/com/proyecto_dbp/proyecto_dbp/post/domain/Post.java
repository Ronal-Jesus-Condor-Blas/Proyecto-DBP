package com.proyecto_dbp.proyecto_dbp.post.domain;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.likeaction.domain.LikeAction;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Clave foránea hacia User
    private User user;  // Un post es creado por un usuario

    private String image;

    private String content;

    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    private PostStatus status;  // Estado del post (activo/eliminado)

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;  // Un post puede tener muchos comentarios

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<LikeAction> likes;  // Un post puede recibir muchos likes

    // Getters and Setters
}
