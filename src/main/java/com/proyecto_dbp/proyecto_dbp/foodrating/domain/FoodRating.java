package com.proyecto_dbp.proyecto_dbp.foodrating.domain;


import com.proyecto_dbp.proyecto_dbp.food.domain.Food;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data  // Lombok generará automáticamente los getters, setters, toString, equals, y hashCode
public class FoodRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodRatingId;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)  // Clave foránea hacia Food
    private Food food;  // Una calificación pertenece a un plato específico

    private int rating;

    private String comment;

    private LocalDateTime ratingDate;
}
