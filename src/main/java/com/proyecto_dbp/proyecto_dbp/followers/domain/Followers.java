package com.proyecto_dbp.proyecto_dbp.followers.domain;


import java.time.LocalDateTime;

import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data  // Lombok genera automáticamente getters, setters, toString, equals, y hashCode
public class Followers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)  // Clave foránea hacia el usuario que sigue
    @NotNull
    private User follower;

    @ManyToOne
    @JoinColumn(name = "followed_id", nullable = false)  // Clave foránea hacia el usuario que es seguido
    @NotNull
    private User followed;

    @NotNull
    private LocalDateTime followDate;  // Fecha en la que comenzó a seguir al usuario
}


