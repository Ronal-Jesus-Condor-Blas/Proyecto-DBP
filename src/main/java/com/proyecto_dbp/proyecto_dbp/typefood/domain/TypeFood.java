package com.proyecto_dbp.proyecto_dbp.typefood.domain;

import com.proyecto_dbp.proyecto_dbp.restaurant.domain.Restaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeFoodId;  // Identificador único del tipo de comida

    @NotNull
    @Size(max = 100)
    private String type;  // Tipo de comida (e.g., italiana, mexicana, peruana)

    @ManyToMany
    @JoinTable(
            name = "restaurant_type_food",
            joinColumns = @JoinColumn(name = "typefood_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id")
    )
    private Set<Restaurant> restaurants;  // Un tipo de comida puede estar presente en muchos restaurantes
}
