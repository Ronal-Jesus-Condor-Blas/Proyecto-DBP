package com.proyecto_dbp.proyecto_dbp.food.domain.services;

import com.proyecto_dbp.proyecto_dbp.food.dto.FoodCreateDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodUpdateDto;

import java.util.List;

public interface FoodService {
    FoodDto createFood(FoodCreateDto foodCreateDto);
    FoodDto getFoodById(Long id);
    List<FoodDto> getAllFoods();
    FoodDto updateFood(Long id, FoodUpdateDto foodUpdateDto);
    void deleteFood(Long id);
}