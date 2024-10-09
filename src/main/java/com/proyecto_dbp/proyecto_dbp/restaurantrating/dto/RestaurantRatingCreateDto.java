package com.proyecto_dbp.proyecto_dbp.restaurantrating.dto;

import lombok.Data;

@Data
public class RestaurantRatingCreateDto {
    private Integer rating;
    private String comment;
    private Long userId;
    private Long restaurantId;
}