package com.proyecto_dbp.proyecto_dbp.foodrating.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.food.domain.Food;
import com.proyecto_dbp.proyecto_dbp.foodrating.domain.FoodRating;
import com.proyecto_dbp.proyecto_dbp.foodrating.domain.services.FoodRatingService;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingDto;
import com.proyecto_dbp.proyecto_dbp.foodrating.infrastructure.FoodRatingRepository;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import com.proyecto_dbp.proyecto_dbp.user.infrastructure.UserRepository;
import com.proyecto_dbp.proyecto_dbp.food.infrastructure.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodRatingServiceImpl implements FoodRatingService {

    @Autowired
    private FoodRatingRepository foodRatingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public FoodRatingDto createFoodRating(FoodRatingCreateDto foodRatingCreateDto) {
        FoodRating foodRating = new FoodRating();
        foodRating.setRating(foodRatingCreateDto.getRating());
        foodRating.setComment(foodRatingCreateDto.getComment());
        foodRating.setRatingDate(LocalDateTime.now());
        foodRating.setUser(userRepository.findById(foodRatingCreateDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found")));
        foodRating.setFood(foodRepository.findById(foodRatingCreateDto.getFoodId())
                .orElseThrow(() -> new RuntimeException("Food not found")));
        FoodRating savedFoodRating = foodRatingRepository.save(foodRating);
        return mapToDto(savedFoodRating);
    }

    @Override
    public FoodRatingDto getFoodRatingById(Long id) {
        FoodRating foodRating = foodRatingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FoodRating not found"));
        return mapToDto(foodRating);
    }

    @Override
    public List<FoodRatingDto> getAllFoodRatings() {
        return foodRatingRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FoodRatingDto updateFoodRating(Long id, FoodRatingCreateDto foodRatingCreateDto) {
        FoodRating foodRating = foodRatingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FoodRating not found"));
        foodRating.setRating(foodRatingCreateDto.getRating());
        foodRating.setComment(foodRatingCreateDto.getComment());
        foodRating.setUser(userRepository.findById(foodRatingCreateDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found")));
        foodRating.setFood(foodRepository.findById(foodRatingCreateDto.getFoodId())
                .orElseThrow(() -> new RuntimeException("Food not found")));
        FoodRating updatedFoodRating = foodRatingRepository.save(foodRating);
        return mapToDto(updatedFoodRating);
    }

    @Override
    public void deleteFoodRating(Long id) {
        FoodRating foodRating = foodRatingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FoodRating not found"));
        foodRatingRepository.delete(foodRating);
    }

    private FoodRatingDto mapToDto(FoodRating foodRating) {
        FoodRatingDto foodRatingDto = new FoodRatingDto();
        foodRatingDto.setFoodRatingId(foodRating.getFoodRatingId());
        foodRatingDto.setRating(foodRating.getRating());
        foodRatingDto.setRatingDate(foodRating.getRatingDate());
        foodRatingDto.setComment(foodRating.getComment());
        foodRatingDto.setUserId(foodRating.getUser().getUserId());
        foodRatingDto.setFoodId(foodRating.getFood().getFoodId());
        return foodRatingDto;
    }
}