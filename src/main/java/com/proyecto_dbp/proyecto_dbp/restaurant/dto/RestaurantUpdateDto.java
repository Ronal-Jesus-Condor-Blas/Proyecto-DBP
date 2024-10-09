package com.proyecto_dbp.proyecto_dbp.restaurant.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class RestaurantUpdateDto {
    private String name;
    private String location;
    private Double averageRating;
    private LocalTime openingTime;  // Hora de apertura
    private LocalTime closingTime;  // Hora de cierre
}