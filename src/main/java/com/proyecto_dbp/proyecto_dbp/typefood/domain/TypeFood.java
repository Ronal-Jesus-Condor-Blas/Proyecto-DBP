package com.proyecto_dbp.proyecto_dbp.typefood.domain;

import com.proyecto_dbp.proyecto_dbp.restaurant.domain.Restaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
public class TypeFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeFoodId;

    @NotNull
    @Size(max = 100)
    private String name;

    // Relación ManyToMany con Restaurant a través de la tabla intermedia restaurant_type_food
    @ManyToMany(mappedBy = "typesOfFood")
    private Set<Restaurant> restaurants;  // Un tipo de comida puede ser ofrecido en varios restaurantes


    @ManyToMany
    @JoinTable(
            name = "restaurant_type_food",
            joinColumns = @JoinColumn(name = "restaurant_id"),  // Clave foránea hacia Restaurant
            inverseJoinColumns = @JoinColumn(name = "type_food_id")  // Clave foránea hacia TypeFood
    )
    private Set<TypeFood> typesOfFood;  // Un restaurante ofrece varios tipos de comida

    // Getters and Setters
}
