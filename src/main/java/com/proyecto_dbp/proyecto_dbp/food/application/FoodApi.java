package com.proyecto_dbp.proyecto_dbp.food.application;

import com.proyecto_dbp.proyecto_dbp.common.ApiPathConstants;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodCreateDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodUpdateDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.FOOD_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface FoodApi {

    @PostMapping
    ResponseEntity<FoodDto> createFood(@RequestBody FoodCreateDto foodCreateDto);

    @GetMapping("/{id}")
    ResponseEntity<FoodDto> getFoodById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<FoodDto>> getAllFoods();

    @PutMapping("/{id}")
    ResponseEntity<FoodDto> updateFood(@PathVariable Long id, @RequestBody FoodUpdateDto foodUpdateDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteFood(@PathVariable Long id);
}
