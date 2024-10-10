package com.proyecto_dbp.proyecto_dbp.food.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class FoodCreateDto {
    private String name;
    private Double price;
    private String status;
    private Long restaurantId;
}