package com.proyecto_dbp.proyecto_dbp.food.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FoodDto {
    private Long foodId;
    private String name;
    private Double price;
    private String status;
    private Double averageRating;
    private LocalDateTime createdDate;
    private Long restaurantId;
}
