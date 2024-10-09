package com.proyecto_dbp.proyecto_dbp.restaurant.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class RestaurantDto {
    private Long restaurantId;
    private String name;
    private String location;
    private Double averageRating;
    private LocalDateTime createdDate;
    private LocalTime openingTime;
    private LocalTime closingTime;
}