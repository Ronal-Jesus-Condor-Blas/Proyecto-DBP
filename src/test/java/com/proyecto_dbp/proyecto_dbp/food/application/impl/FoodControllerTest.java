package com.proyecto_dbp.proyecto_dbp.food.application.impl;

import com.proyecto_dbp.proyecto_dbp.food.domain.Food;
import com.proyecto_dbp.proyecto_dbp.food.domain.FoodStatus;
import com.proyecto_dbp.proyecto_dbp.food.domain.services.FoodService;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodCreateDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodDto;
import com.proyecto_dbp.proyecto_dbp.food.dto.FoodUpdateDto;
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
class FoodControllerTest {

    @Mock
    private FoodService foodService;

    @InjectMocks
    private FoodController foodController;

    private static final Long FOOD_ID = 1L;

    // Aquí utilizamos el Enum para el campo status en la entidad
    private static final Food FOOD = Food.builder()
            .foodId(FOOD_ID)
            .name("Pizza")
            .price(12.99)
            .createdDate(LocalDateTime.now())
            .status(FoodStatus.AVAILABLE)  // Usamos el Enum para la entidad
            .build();

    // Aquí utilizamos String para el campo status en los DTOs
    private static final FoodCreateDto FOOD_CREATE_DTO = FoodCreateDto.builder()
            .name("Pizza")
            .price(12.99)
            .status("AVAILABLE")  // String para los DTOs
            .restaurantId(1L)
            .build();

    private static final FoodDto FOOD_DTO = FoodDto.builder()
            .foodId(FOOD_ID)
            .name("Pizza")
            .price(12.99)
            .status("AVAILABLE")  // String para los DTOs
            .createdDate(LocalDateTime.now())
            .restaurantId(1L)
            .build();

    private static final FoodUpdateDto FOOD_UPDATE_DTO = FoodUpdateDto.builder()
            .name("Updated Pizza")
            .price(14.99)
            .status("AVAILABLE")  // String para los DTOs
            .averageRating(4.5)
            .build();

    @Test
    void it_should_return_non_null_when_create_food() {
        Mockito.when(foodService.createFood(FOOD_CREATE_DTO))
                .thenReturn(FOOD_DTO);

        assertThat(foodController.createFood(FOOD_CREATE_DTO))
                .isNotNull();
    }

    @Test
    void it_should_return_expected_food_when_create_food() {
        Mockito.when(foodService.createFood(FOOD_CREATE_DTO))
                .thenReturn(FOOD_DTO);

        assertThat(foodController.createFood(FOOD_CREATE_DTO).getBody())
                .isEqualTo(FOOD_DTO);
    }

    @Test
    void it_should_return_expected_200_when_create_food() {
        Mockito.when(foodService.createFood(FOOD_CREATE_DTO))
                .thenReturn(FOOD_DTO);

        assertThat(foodController.createFood(FOOD_CREATE_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_non_null_when_get_food_by_id() {
        Mockito.when(foodService.getFoodById(FOOD_ID))
                .thenReturn(FOOD_DTO);

        assertThat(foodController.getFoodById(FOOD_ID))
                .isNotNull();
    }

    @Test
    void it_should_return_expected_food_when_get_food_by_id() {
        Mockito.when(foodService.getFoodById(FOOD_ID))
                .thenReturn(FOOD_DTO);

        assertThat(foodController.getFoodById(FOOD_ID).getBody())
                .isEqualTo(FOOD_DTO);
    }

    @Test
    void it_should_return_expected_200_when_get_food_by_id() {
        Mockito.when(foodService.getFoodById(FOOD_ID))
                .thenReturn(FOOD_DTO);

        assertThat(foodController.getFoodById(FOOD_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_updated_food_when_update_food() {
        Mockito.when(foodService.updateFood(FOOD_ID, FOOD_UPDATE_DTO))
                .thenReturn(FOOD_DTO);

        assertThat(foodController.updateFood(FOOD_ID, FOOD_UPDATE_DTO).getBody())
                .isEqualTo(FOOD_DTO);
    }

    @Test
    void it_should_return_expected_200_when_update_food() {
        Mockito.when(foodService.updateFood(FOOD_ID, FOOD_UPDATE_DTO))
                .thenReturn(FOOD_DTO);

        assertThat(foodController.updateFood(FOOD_ID, FOOD_UPDATE_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_no_content_when_delete_food() {
        Mockito.doNothing().when(foodService).deleteFood(FOOD_ID);

        assertThat(foodController.deleteFood(FOOD_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(204));
    }
}
