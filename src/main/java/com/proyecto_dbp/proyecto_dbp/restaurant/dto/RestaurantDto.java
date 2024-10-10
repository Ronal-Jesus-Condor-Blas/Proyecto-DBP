package com.proyecto_dbp.proyecto_dbp.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder  // Agregamos patrón builder
@NoArgsConstructor  // Constructor sin argumentos
@AllArgsConstructor  // Constructor con todos los argumentos
public class RestaurantDto {
    private Long restaurantId;
    private String name;
    private String location;
    private Double averageRating;
    private LocalDateTime createdDate;
    private LocalTime openingTime;
    private LocalTime closingTime;
}
