package com.proyecto_dbp.proyecto_dbp.restauranttypefood.domain;

import com.proyecto_dbp.proyecto_dbp.restaurant.domain.Restaurant;
import com.proyecto_dbp.proyecto_dbp.typefood.domain.TypeFood;
import jakarta.persistence.*;

@Entity
public class RestaurantTypeFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)  // Clave foránea hacia Restaurante
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "type_food_id", nullable = false)  // Clave foránea hacia TypeFood
    private TypeFood typeFood;

    // Getters and Setters
}
