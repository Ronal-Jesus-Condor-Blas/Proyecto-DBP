package com.proyecto_dbp.proyecto_dbp.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder  // Agregamos patrón builder
@NoArgsConstructor  // Constructor sin argumentos
@AllArgsConstructor  // Constructor con todos los argumentos
public class RestaurantCreateDto {
    private String name;
    private String location;
    private LocalTime openingTime;
    private LocalTime closingTime;
}
