package com.proyecto_dbp.proyecto_dbp.foodrating.dto;

import lombok.Data;

@Data
public class FoodRatingCreateDto {
    private Integer rating;
    private String comment;
    private Long userId;
    private Long foodId;
}