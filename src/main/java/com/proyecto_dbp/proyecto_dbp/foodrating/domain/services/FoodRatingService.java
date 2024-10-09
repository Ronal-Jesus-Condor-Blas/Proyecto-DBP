package com.proyecto_dbp.proyecto_dbp.foodrating.domain.services;

import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingDto;

import java.util.List;

public interface FoodRatingService {
    FoodRatingDto createFoodRating(FoodRatingCreateDto foodRatingCreateDto);
    FoodRatingDto getFoodRatingById(Long id);
    List<FoodRatingDto> getAllFoodRatings();
    FoodRatingDto updateFoodRating(Long id, FoodRatingCreateDto foodRatingCreateDto);
    void deleteFoodRating(Long id);
}