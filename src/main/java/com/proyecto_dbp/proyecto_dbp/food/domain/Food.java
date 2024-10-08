package com.proyecto_dbp.proyecto_dbp.food.domain;

import com.proyecto_dbp.proyecto_dbp.foodrating.domain.FoodRating;
import com.proyecto_dbp.proyecto_dbp.restaurant.domain.Restaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder  // Añadimos el soporte para el patrón Builder
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId; // Identificador único del plato

    @NotNull
    @Size(max = 100)
    private String name; // Nombre del plato

    @NotNull
    private Double price; // Precio del plato

    private Double averageRating; // Calificación promedio del plato

    private LocalDateTime createdDate; // Fecha de creación del plato

    @Enumerated(EnumType.STRING)
    private FoodStatus status;  // Enum para el estado del plato (disponible/no disponible)

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)  // Clave foránea hacia Restaurant
    private Restaurant restaurant;  // Un plato pertenece a un restaurante

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<FoodRating> foodRatings;  // Un plato puede tener muchas calificaciones
}
