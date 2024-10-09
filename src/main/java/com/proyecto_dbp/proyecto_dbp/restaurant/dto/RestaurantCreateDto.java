package com.proyecto_dbp.proyecto_dbp.restaurant.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class RestaurantCreateDto {
    private String name;
    private String location;
    private LocalTime openingTime;  // Hora de apertura
    private LocalTime closingTime;  // Hora de cierre
}