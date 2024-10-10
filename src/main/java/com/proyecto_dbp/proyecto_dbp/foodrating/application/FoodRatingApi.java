package com.proyecto_dbp.proyecto_dbp.foodrating.application;

import com.proyecto_dbp.proyecto_dbp.common.ApiPathConstants;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.FOOD_RATING_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface FoodRatingApi {

    @PostMapping
    ResponseEntity<FoodRatingDto> createFoodRating(@RequestBody FoodRatingCreateDto foodRatingCreateDto);

    @GetMapping("/{id}")
    ResponseEntity<FoodRatingDto> getFoodRatingById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<FoodRatingDto>> getAllFoodRatings();

    @PutMapping("/{id}")
    ResponseEntity<FoodRatingDto> updateFoodRating(@PathVariable Long id, @RequestBody FoodRatingCreateDto foodRatingCreateDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteFoodRating(@PathVariable Long id);
}
