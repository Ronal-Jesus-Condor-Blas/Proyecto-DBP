package com.proyecto_dbp.proyecto_dbp.restaurant.domain;
import com.proyecto_dbp.proyecto_dbp.food.domain.Food;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.RestaurantRating;
import com.proyecto_dbp.proyecto_dbp.typefood.domain.TypeFood;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data  // Lombok generará automáticamente los getters, setters, toString, equals, y hashCode
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId; // Identificador único del restaurante

    @NotNull
    @Size(max = 100)
    private String name; // Nombre del restaurante

    @NotNull
    private String location; // Ubicación del restaurante

    private Double averageRating; // Calificación promedio del restaurante

    private LocalDateTime createdDate; // Fecha de creación del restaurante

    @Enumerated(EnumType.STRING)
    private RestaurantStatus status;  // Enum para el estado del restaurante (abierto/cerrado)

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<Food> foods;  // Un restaurante ofrece varios platos

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<RestaurantRating> ratings;  // Un restaurante puede recibir varias calificaciones

    @ManyToMany
    @JoinTable(
            name = "restaurant_type_food",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "type_food_id")
    ) // Tabla intermedia para la relación muchos a muchos

    private Set<TypeFood> typesOfFood;  // Un restaurante ofrece varios tipos de cocina
}
