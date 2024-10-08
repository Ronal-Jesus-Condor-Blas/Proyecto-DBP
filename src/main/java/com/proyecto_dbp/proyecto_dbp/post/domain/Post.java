package com.proyecto_dbp.proyecto_dbp.post.domain;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId; // Identificador del post

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Clave foránea hacia User
    private User user;  // Un post es hecho por un usuario

    private String image; // Imagen del post

    private String content; // Contenido del post

    private LocalDateTime createdDate; // Fecha y hora en la que se creó el post

    @Enumerated(EnumType.STRING)
    private PostStatus status;  // Estado del post (activo/eliminado)

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments;  // Un post puede tener muchos comentarios

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "post_likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    ) // Tabla intermedia para la relación muchos a muchos entre Post y User

    private Set<User> likedBy;  // Un post puede ser gustado por muchos usuarios
}
