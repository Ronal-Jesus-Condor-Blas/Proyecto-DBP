package com.proyecto_dbp.proyecto_dbp.food.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.exception.EntityNotFoundException;
import com.proyecto_dbp.proyecto_dbp.food.domain.Food;
import com.proyecto_dbp.proyecto_dbp.food.domain.FoodStatus;
import com.proyecto_dbp.proyecto_dbp.food.domain.services.FoodService;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodCreateDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodUpdateDto;
import com.proyecto_dbp.proyecto_dbp.food.infrastructure.FoodRepository;
import com.proyecto_dbp.proyecto_dbp.restaurant.infrastructure.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    // Inyección por constructor
    public FoodServiceImpl(FoodRepository foodRepository, RestaurantRepository restaurantRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public FoodDto createFood(FoodCreateDto foodCreateDto) {
        Food food = mapToEntity(foodCreateDto);
        Food savedFood = foodRepository.save(food);
        return mapToDto(savedFood);
    }


    @Override
    public FoodDto getFoodById(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));
        return mapToDto(food);
    }

    @Override
    public List<FoodDto> getAllFoods() {
        return foodRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FoodDto updateFood(Long id, FoodUpdateDto foodUpdateDto) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));
        updateFields(food, foodUpdateDto);
        Food updatedFood = foodRepository.save(food);
        return mapToDto(updatedFood);
    }

    @Override
    public void deleteFood(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));
        foodRepository.delete(food);
    }

    // Mapeo de entidad a DTO
    private FoodDto mapToDto(Food food) {
        return FoodDto.builder()
                .foodId(food.getFoodId())
                .name(food.getName())
                .price(food.getPrice())
                .status(food.getStatus().name())  // Convertir Enum a String
                .averageRating(food.getAverageRating())
                .createdDate(food.getCreatedDate())
                .restaurantId(food.getRestaurant().getRestaurantId())
                .build();
    }


    // Mapeo de DTO a entidad
    private Food mapToEntity(FoodCreateDto foodCreateDto) {
        return Food.builder()
                .name(foodCreateDto.getName())
                .price(foodCreateDto.getPrice())
                .status(FoodStatus.valueOf(foodCreateDto.getStatus()))
                .createdDate(LocalDateTime.now())
                .restaurant(restaurantRepository.findById(foodCreateDto.getRestaurantId())
                        .orElseThrow(() -> new EntityNotFoundException("Restaurant not found")))
                .build();
    }

    // Actualización de campos
    private void updateFields(Food food, FoodUpdateDto foodUpdateDto) {
        food.setName(foodUpdateDto.getName());
        food.setPrice(foodUpdateDto.getPrice());
        food.setStatus(FoodStatus.valueOf(foodUpdateDto.getStatus()));
        food.setAverageRating(foodUpdateDto.getAverageRating());
    }
}