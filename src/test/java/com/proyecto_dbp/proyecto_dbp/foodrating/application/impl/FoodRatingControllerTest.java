package com.proyecto_dbp.proyecto_dbp.foodrating.application.impl;

import com.proyecto_dbp.proyecto_dbp.foodrating.domain.FoodRating;
import com.proyecto_dbp.proyecto_dbp.foodrating.domain.services.FoodRatingService;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.foodrating.dto.FoodRatingDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class FoodRatingControllerTest {

    @Mock
    private FoodRatingService foodRatingService;

    @InjectMocks
    private FoodRatingController foodRatingController;

    private static final Long FOOD_RATING_ID = 1L;
    private static final Long USER_ID = 1L;
    private static final Long FOOD_ID = 1L;

    // Definimos la entidad FoodRating
    private static final FoodRating FOOD_RATING = FoodRating.builder()
            .foodRatingId(FOOD_RATING_ID)
            .rating(5)
            .comment("Excellent food!")
            .ratingDate(LocalDateTime.now())
            .build();

    // Definimos el DTO para crear un FoodRating
    private static final FoodRatingCreateDto FOOD_RATING_CREATE_DTO = FoodRatingCreateDto.builder()
            .rating(5)
            .comment("Excellent food!")
            .userId(USER_ID)
            .foodId(FOOD_ID)
            .build();

    // Definimos el DTO para devolver un FoodRating
    private static final FoodRatingDto FOOD_RATING_DTO = FoodRatingDto.builder()
            .foodRatingId(FOOD_RATING_ID)
            .rating(5)
            .comment("Excellent food!")
            .ratingDate(LocalDateTime.now())
            .userId(USER_ID)
            .foodId(FOOD_ID)
            .build();

    @Test
    void it_should_return_non_null_when_create_food_rating() {
        Mockito.when(foodRatingService.createFoodRating(FOOD_RATING_CREATE_DTO))
                .thenReturn(FOOD_RATING_DTO);

        assertThat(foodRatingController.createFoodRating(FOOD_RATING_CREATE_DTO))
                .isNotNull();
    }

    @Test
    void it_should_return_expected_food_rating_when_create_food_rating() {
        Mockito.when(foodRatingService.createFoodRating(FOOD_RATING_CREATE_DTO))
                .thenReturn(FOOD_RATING_DTO);

        assertThat(foodRatingController.createFoodRating(FOOD_RATING_CREATE_DTO).getBody())
                .isEqualTo(FOOD_RATING_DTO);
    }

    @Test
    void it_should_return_expected_200_when_create_food_rating() {
        Mockito.when(foodRatingService.createFoodRating(FOOD_RATING_CREATE_DTO))
                .thenReturn(FOOD_RATING_DTO);

        assertThat(foodRatingController.createFoodRating(FOOD_RATING_CREATE_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_non_null_when_get_food_rating_by_id() {
        Mockito.when(foodRatingService.getFoodRatingById(FOOD_RATING_ID))
                .thenReturn(FOOD_RATING_DTO);

        assertThat(foodRatingController.getFoodRatingById(FOOD_RATING_ID))
                .isNotNull();
    }

    @Test
    void it_should_return_expected_food_rating_when_get_food_rating_by_id() {
        Mockito.when(foodRatingService.getFoodRatingById(FOOD_RATING_ID))
                .thenReturn(FOOD_RATING_DTO);

        assertThat(foodRatingController.getFoodRatingById(FOOD_RATING_ID).getBody())
                .isEqualTo(FOOD_RATING_DTO);
    }

    @Test
    void it_should_return_expected_200_when_get_food_rating_by_id() {
        Mockito.when(foodRatingService.getFoodRatingById(FOOD_RATING_ID))
                .thenReturn(FOOD_RATING_DTO);

        assertThat(foodRatingController.getFoodRatingById(FOOD_RATING_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_no_content_when_delete_food_rating() {
        Mockito.doNothing().when(foodRatingService).deleteFoodRating(FOOD_RATING_ID);

        assertThat(foodRatingController.deleteFoodRating(FOOD_RATING_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Test
    void it_should_return_updated_food_rating_when_update_food_rating() {
        Mockito.when(foodRatingService.updateFoodRating(FOOD_RATING_ID, FOOD_RATING_CREATE_DTO))
                .thenReturn(FOOD_RATING_DTO);

        assertThat(foodRatingController.updateFoodRating(FOOD_RATING_ID, FOOD_RATING_CREATE_DTO).getBody())
                .isEqualTo(FOOD_RATING_DTO);
    }

    @Test
    void it_should_return_expected_200_when_update_food_rating() {
        Mockito.when(foodRatingService.updateFoodRating(FOOD_RATING_ID, FOOD_RATING_CREATE_DTO))
                .thenReturn(FOOD_RATING_DTO);

        assertThat(foodRatingController.updateFoodRating(FOOD_RATING_ID, FOOD_RATING_CREATE_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }
}
