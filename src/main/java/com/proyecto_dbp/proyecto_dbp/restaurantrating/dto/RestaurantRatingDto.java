package com.proyecto_dbp.proyecto_dbp.restaurantrating.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RestaurantRatingDto {
    private Long restaurantRatingId;
    private Integer rating;
    private LocalDateTime ratingDate;
    private String comment;
    private Long userId;
    private Long restaurantId;
}