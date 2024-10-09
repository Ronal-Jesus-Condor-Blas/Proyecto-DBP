package com.proyecto_dbp.proyecto_dbp.foodrating.application.impl;

import com.proyecto_dbp.proyecto_dbp.foodrating.application.FoodRatingApi;
import com.proyecto_dbp.proyecto_dbp.foodrating.domain.services.FoodRatingService;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodRatingController implements FoodRatingApi {

    @Autowired
    private FoodRatingService foodRatingService;

    @Override
    public FoodRatingDto createFoodRating(FoodRatingCreateDto foodRatingCreateDto) {
        return foodRatingService.createFoodRating(foodRatingCreateDto);
    }

    @Override
    public FoodRatingDto getFoodRatingById(Long id) {
        return foodRatingService.getFoodRatingById(id);
    }

    @Override
    public List<FoodRatingDto> getAllFoodRatings() {
        return foodRatingService.getAllFoodRatings();
    }

    @Override
    public FoodRatingDto updateFoodRating(Long id, FoodRatingCreateDto foodRatingCreateDto) {
        return foodRatingService.updateFoodRating(id, foodRatingCreateDto);
    }

    @Override
    public void deleteFoodRating(Long id) {
        foodRatingService.deleteFoodRating(id);
    }
}