package com.proyecto_dbp.proyecto_dbp.restaurant.domain;

import com.proyecto_dbp.proyecto_dbp.food.domain.Food;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.RestaurantRating;
import com.proyecto_dbp.proyecto_dbp.typefood.domain.TypeFood;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@Builder  // Para permitir el patrón de construcción
@NoArgsConstructor  // Constructor sin argumentos
@AllArgsConstructor  // Constructor con todos los argumentos
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    private String location;

    private Double averageRating;

    private LocalDateTime createdDate;

    private LocalTime openingTime;

    private LocalTime closingTime;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<Food> foods;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<RestaurantRating> ratings;

    @ManyToMany
    @JoinTable(
            name = "restaurant_type_food",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "typefood_id")
    )
    private Set<TypeFood> typesOfFood;
}
