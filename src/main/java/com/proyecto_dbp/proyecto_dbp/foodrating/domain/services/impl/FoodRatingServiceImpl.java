package com.proyecto_dbp.proyecto_dbp.foodrating.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.exception.EntityNotFoundException;
import com.proyecto_dbp.proyecto_dbp.foodrating.domain.FoodRating;
import com.proyecto_dbp.proyecto_dbp.foodrating.domain.services.FoodRatingService;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingDto;
import com.proyecto_dbp.proyecto_dbp.foodrating.infrastructure.FoodRatingRepository;
import com.proyecto_dbp.proyecto_dbp.user.infrastructure.UserRepository;
import com.proyecto_dbp.proyecto_dbp.food.infrastructure.FoodRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodRatingServiceImpl implements FoodRatingService {

    private final FoodRatingRepository foodRatingRepository;
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    // Inyección por constructor
    public FoodRatingServiceImpl(FoodRatingRepository foodRatingRepository, UserRepository userRepository, FoodRepository foodRepository) {
        this.foodRatingRepository = foodRatingRepository;
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public FoodRatingDto createFoodRating(FoodRatingCreateDto foodRatingCreateDto) {
        FoodRating foodRating = mapToEntity(foodRatingCreateDto);
        FoodRating savedFoodRating = foodRatingRepository.save(foodRating);
        return mapToDto(savedFoodRating);
    }

    @Override
    public FoodRatingDto getFoodRatingById(Long id) {
        FoodRating foodRating = foodRatingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FoodRating not found"));
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
                .orElseThrow(() -> new EntityNotFoundException("FoodRating not found"));
        updateFields(foodRating, foodRatingCreateDto);
        FoodRating updatedFoodRating = foodRatingRepository.save(foodRating);
        return mapToDto(updatedFoodRating);
    }

    @Override
    public void deleteFoodRating(Long id) {
        FoodRating foodRating = foodRatingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FoodRating not found"));
        foodRatingRepository.delete(foodRating);
    }

    // Mapeo de entidad a DTO
    private FoodRatingDto mapToDto(FoodRating foodRating) {
        return FoodRatingDto.builder()
                .foodRatingId(foodRating.getFoodRatingId())
                .rating(foodRating.getRating())
                .comment(foodRating.getComment())
                .ratingDate(foodRating.getRatingDate())
                .userId(foodRating.getUser().getUserId())
                .foodId(foodRating.getFood().getFoodId())
                .build();
    }

    // Mapeo de DTO a entidad
    private FoodRating mapToEntity(FoodRatingCreateDto foodRatingCreateDto) {
        return FoodRating.builder()
                .rating(foodRatingCreateDto.getRating())
                .comment(foodRatingCreateDto.getComment())
                .ratingDate(LocalDateTime.now())
                .user(userRepository.findById(foodRatingCreateDto.getUserId())
                        .orElseThrow(() -> new EntityNotFoundException("User not found")))
                .food(foodRepository.findById(foodRatingCreateDto.getFoodId())
                        .orElseThrow(() -> new EntityNotFoundException("Food not found")))
                .build();
    }

    // Actualización de campos
    private void updateFields(FoodRating foodRating, FoodRatingCreateDto foodRatingCreateDto) {
        foodRating.setRating(foodRatingCreateDto.getRating());
        foodRating.setComment(foodRatingCreateDto.getComment());
        foodRating.setUser(userRepository.findById(foodRatingCreateDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found")));
        foodRating.setFood(foodRepository.findById(foodRatingCreateDto.getFoodId())
                .orElseThrow(() -> new EntityNotFoundException("Food not found")));
    }
}
