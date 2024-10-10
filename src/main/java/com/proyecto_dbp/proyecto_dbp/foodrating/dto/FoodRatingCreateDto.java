package com.proyecto_dbp.proyecto_dbp.foodrating.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class FoodRatingCreateDto {
    private Integer rating;
    private String comment;
    private Long userId;
    private Long foodId;
}