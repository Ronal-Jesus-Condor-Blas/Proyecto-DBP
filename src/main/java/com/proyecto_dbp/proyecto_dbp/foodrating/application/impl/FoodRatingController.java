package com.proyecto_dbp.proyecto_dbp.foodrating.application.impl;

import com.proyecto_dbp.proyecto_dbp.foodrating.application.FoodRatingApi;
import com.proyecto_dbp.proyecto_dbp.foodrating.domain.services.FoodRatingService;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodRatingController implements FoodRatingApi {

    private final FoodRatingService foodRatingService;

    // Inyección por constructor
    public FoodRatingController(FoodRatingService foodRatingService) {
        this.foodRatingService = foodRatingService;
    }

    @Override
    public ResponseEntity<FoodRatingDto> createFoodRating(FoodRatingCreateDto foodRatingCreateDto) {
        return ResponseEntity.ok(foodRatingService.createFoodRating(foodRatingCreateDto));
    }

    @Override
    public ResponseEntity<FoodRatingDto> getFoodRatingById(Long id) {
        return ResponseEntity.ok(foodRatingService.getFoodRatingById(id));
    }

    @Override
    public ResponseEntity<List<FoodRatingDto>> getAllFoodRatings() {
        return ResponseEntity.ok(foodRatingService.getAllFoodRatings());
    }

    @Override
    public ResponseEntity<FoodRatingDto> updateFoodRating(Long id, FoodRatingCreateDto foodRatingCreateDto) {
        return ResponseEntity.ok(foodRatingService.updateFoodRating(id, foodRatingCreateDto));
    }

    @Override
    public ResponseEntity<Void> deleteFoodRating(Long id) {
        foodRatingService.deleteFoodRating(id);
        return ResponseEntity.noContent().build();  // 204 No Content tras eliminar
    }
}
