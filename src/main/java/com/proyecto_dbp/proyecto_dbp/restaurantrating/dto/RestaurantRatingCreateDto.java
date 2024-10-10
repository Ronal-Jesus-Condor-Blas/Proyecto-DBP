package com.proyecto_dbp.proyecto_dbp.restaurantrating.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder  // Agregamos el patrón builder
@NoArgsConstructor  // Constructor sin argumentos
@AllArgsConstructor  // Constructor con todos los argumentos
public class RestaurantRatingCreateDto {
    private Integer rating;
    private String comment;
    private Long userId;
    private Long restaurantId;
}
