package com.proyecto_dbp.proyecto_dbp.restaurantrating.domain;


import com.proyecto_dbp.proyecto_dbp.restaurant.domain.Restaurant;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data  // Lombok generará automáticamente los getters, setters, toString, equals, y hashCode
public class RestaurantRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantRatingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Clave foránea hacia User
    private User user;  // Una calificación es hecha por un usuario

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)  // Clave foránea hacia Restaurant
    private Restaurant restaurant;  // Una calificación está asociada a un restaurante

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;  // Calificación de 1 a 5 estrellas

    private String comment;  // Comentario opcional

    private LocalDateTime ratingDate;  // Fecha en la que se realizó la calificación
}

