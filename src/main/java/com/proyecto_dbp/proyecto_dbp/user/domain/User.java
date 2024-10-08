package com.proyecto_dbp.proyecto_dbp.user.domain;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.foodrating.domain.FoodRating;
import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.RestaurantRating;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // Identificador único del usuario

    @Size(max = 50)
    private String name; // Nombre del usuario

    @Email
    private String email; // Correo electrónico del usuario

    private String password; // Contraseña del usuario

    private String profilePicture; // URL de la foto de perfil

    private String biography; // Biografía del usuario

    @Enumerated(EnumType.STRING)
    private UserType userType; // Tipo de usuario (consumidor/influencer)

    private LocalDateTime registerDate; // Fecha y hora de registro

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Post> posts;  // Un usuario puede crear muchos posts

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Comment> comments;  // Un usuario puede hacer muchos comentarios

    @ManyToMany
    @JoinTable(
            name = "user_follows",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "followed_id")
    ) // Tabla intermedia para la relación muchos a muchos entre User y User

    private Set<User> followers;  // Usuarios que siguen a este usuario

    @ManyToMany(mappedBy = "likedBy")
    private Set<Post> likedPosts; // Posts que le gustan a este usuario

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<FoodRating> foodRatings;  // Un usuario puede calificar muchos platos

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<RestaurantRating> restaurantRatings;  // Un usuario puede calificar muchos restaurantes

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userType.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
