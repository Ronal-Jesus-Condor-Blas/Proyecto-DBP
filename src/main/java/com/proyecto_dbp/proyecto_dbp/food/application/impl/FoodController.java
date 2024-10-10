package com.proyecto_dbp.proyecto_dbp.food.application.impl;

import com.proyecto_dbp.proyecto_dbp.food.application.FoodApi;
import com.proyecto_dbp.proyecto_dbp.food.domain.services.FoodService;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodCreateDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController implements FoodApi {

    private final FoodService foodService;

    // Inyección por constructor (mejor práctica)
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @Override
    public ResponseEntity<FoodDto> createFood(FoodCreateDto foodCreateDto) {
        return ResponseEntity.ok(foodService.createFood(foodCreateDto));
    }

    @Override
    public ResponseEntity<FoodDto> getFoodById(Long id) {
        return ResponseEntity.ok(foodService.getFoodById(id));
    }

    @Override
    public ResponseEntity<List<FoodDto>> getAllFoods() {
        return ResponseEntity.ok(foodService.getAllFoods());
    }

    @Override
    public ResponseEntity<FoodDto> updateFood(Long id, FoodUpdateDto foodUpdateDto) {
        return ResponseEntity.ok(foodService.updateFood(id, foodUpdateDto));
    }

    @Override
    public ResponseEntity<Void> deleteFood(Long id) {
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build(); // 204 No Content después de eliminar
    }
}
