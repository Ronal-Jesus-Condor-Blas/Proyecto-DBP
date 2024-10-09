package com.proyecto_dbp.proyecto_dbp.food.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.food.domain.Food;
import com.proyecto_dbp.proyecto_dbp.food.domain.services.FoodService;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodCreateDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodUpdateDto;
import com.proyecto_dbp.proyecto_dbp.food.infrastructure.FoodRepository;
import com.proyecto_dbp.proyecto_dbp.restaurant.infrastructure.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public FoodDto createFood(FoodCreateDto foodCreateDto) {
        Food food = new Food();
        food.setName(foodCreateDto.getName());
        food.setPrice(foodCreateDto.getPrice());
        food.setStatus(foodCreateDto.getStatus());
        food.setCreatedDate(LocalDateTime.now());
        food.setRestaurant(restaurantRepository.findById(foodCreateDto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found")));
        Food savedFood = foodRepository.save(food);
        return mapToDto(savedFood);
    }

    @Override
    public FoodDto getFoodById(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
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
                .orElseThrow(() -> new RuntimeException("Food not found"));
        food.setName(foodUpdateDto.getName());
        food.setPrice(foodUpdateDto.getPrice());
        food.setStatus(foodUpdateDto.getStatus());
        food.setAverageRating(foodUpdateDto.getAverageRating());
        Food updatedFood = foodRepository.save(food);
        return mapToDto(updatedFood);
    }

    @Override
    public void deleteFood(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
        foodRepository.delete(food);
    }

    private FoodDto mapToDto(Food food) {
        FoodDto foodDto = new FoodDto();
        foodDto.setFoodId(food.getFoodId());
        foodDto.setName(food.getName());
        foodDto.setPrice(food.getPrice());
        foodDto.setStatus(food.getStatus());
        foodDto.setAverageRating(food.getAverageRating());
        foodDto.setCreatedDate(food.getCreatedDate());
        foodDto.setRestaurantId(food.getRestaurant().getRestaurantId());
        return foodDto;
    }
}