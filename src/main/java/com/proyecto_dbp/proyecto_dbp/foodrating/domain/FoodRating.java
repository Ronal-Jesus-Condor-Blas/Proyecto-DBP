package com.proyecto_dbp.proyecto_dbp.foodrating.domain;


import com.proyecto_dbp.proyecto_dbp.food.domain.Food;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data  // Lombok generará automáticamente los getters, setters, toString, equals, y hashCode
public class FoodRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodRatingId; // Identificador único de la calificación

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)  // Clave foránea hacia Food
    private Food food;  // Una calificación pertenece a un plato específico

    private String comment; // Comentario de la calificación

    private LocalDateTime ratingDate; // Fecha de la calificación

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;  // Calificación de 1 a 5 estrellas

    @ManyToOne
    private User user; // Calificación hecha por un usuario

}
