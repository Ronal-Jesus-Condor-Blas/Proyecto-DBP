package com.proyecto_dbp.proyecto_dbp.foodrating.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Builder
@Data
public class FoodRatingDto {
    private Long foodRatingId;
    private Integer rating;
    private LocalDateTime ratingDate;
    private String comment;
    private Long userId;
    private Long foodId;
}