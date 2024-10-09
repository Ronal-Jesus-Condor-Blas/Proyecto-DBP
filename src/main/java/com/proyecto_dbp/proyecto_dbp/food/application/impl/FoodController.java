package com.proyecto_dbp.proyecto_dbp.food.application.impl;

import com.proyecto_dbp.proyecto_dbp.food.application.FoodApi;
import com.proyecto_dbp.proyecto_dbp.food.domain.services.FoodService;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodCreateDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController implements FoodApi {

    @Autowired
    private FoodService foodService;

    @Override
    public FoodDto createFood(FoodCreateDto foodCreateDto) {
        return foodService.createFood(foodCreateDto);
    }

    @Override
    public FoodDto getFoodById(Long id) {
        return foodService.getFoodById(id);
    }

    @Override
    public List<FoodDto> getAllFoods() {
        return foodService.getAllFoods();
    }

    @Override
    public FoodDto updateFood(Long id, FoodUpdateDto foodUpdateDto) {
        return foodService.updateFood(id, foodUpdateDto);
    }

    @Override
    public void deleteFood(Long id) {
        foodService.deleteFood(id);
    }
}