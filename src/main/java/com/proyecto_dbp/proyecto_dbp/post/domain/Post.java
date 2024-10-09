package com.proyecto_dbp.proyecto_dbp.post.domain;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId; // Identificador del post

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Clave foránea hacia User
    private User user;  // Un post es hecho por un usuario

    @ElementCollection
    @CollectionTable(name = "post_photos", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "photo_url")
    private Set<String> photos; // Imagen del post

    @Column(nullable = false, length = 100)
    private String title; // Título del post

    @Column(nullable = false, length = 1000)
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
    private Set<User> likedBy = new HashSet<>();  // Un post puede ser gustado por muchos usuarios

    @Column(nullable = false)
    private int likeCount = 0;  // Contador de likes

    public void incrementLikes(User user) {
        if (likedBy.add(user)) {
            likeCount++;
        }
    }

    public void decrementLikes(User user) {
        if (likedBy.remove(user)) {
            likeCount--;
        }
    }

    public void incrementComments(Comment comment) {
        comments.add(comment);
    }
}