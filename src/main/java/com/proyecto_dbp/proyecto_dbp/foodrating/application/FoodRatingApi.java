package com.proyecto_dbp.proyecto_dbp.foodrating.application;

import com.proyecto_dbp.proyecto_dbp.common.ApiPathConstants;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.FOOD_RATING_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface FoodRatingApi {

    @PostMapping
    FoodRatingDto createFoodRating(@RequestBody FoodRatingCreateDto foodRatingCreateDto);

    @GetMapping("/{id}")
    FoodRatingDto getFoodRatingById(@PathVariable Long id);

    @GetMapping
    List<FoodRatingDto> getAllFoodRatings();

    @PutMapping("/{id}")
    FoodRatingDto updateFoodRating(@PathVariable Long id, @RequestBody FoodRatingCreateDto foodRatingCreateDto);

    @DeleteMapping("/{id}")
    void deleteFoodRating(@PathVariable Long id);
}