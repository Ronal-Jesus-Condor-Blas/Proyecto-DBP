package com.proyecto_dbp.proyecto_dbp.restaurantrating.application;

import com.proyecto_dbp.proyecto_dbp.common.ApiPathConstants;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.RESTAURANT_RATING_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface RestaurantRatingApi {

    @PostMapping
    ResponseEntity<RestaurantRatingDto> createRestaurantRating(@RequestBody RestaurantRatingCreateDto restaurantRatingCreateDto);

    @GetMapping("/{id}")
    ResponseEntity<RestaurantRatingDto> getRestaurantRatingById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<RestaurantRatingDto>> getAllRestaurantRatings();

    @PutMapping("/{id}")
    ResponseEntity<RestaurantRatingDto> updateRestaurantRating(@PathVariable Long id, @RequestBody RestaurantRatingCreateDto restaurantRatingCreateDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRestaurantRating(@PathVariable Long id);
}
