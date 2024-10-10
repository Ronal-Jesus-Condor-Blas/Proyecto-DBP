package com.proyecto_dbp.proyecto_dbp.typefood.application.impl;

import com.proyecto_dbp.proyecto_dbp.typefood.domain.services.TypeFoodService;
import com.proyecto_dbp.proyecto_dbp.typefood.dto.TypeFoodDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class TypeFoodControllerTest {

    @Test
    void it_should_return_non_null_when_create_type_food() {
        Mockito.when(typeFoodService.createTypeFood(TYPE_FOOD_DTO))
                .thenReturn(TYPE_FOOD_DTO);

        assertThat(typeFoodController.createTypeFood(TYPE_FOOD_DTO))
                .isNotNull();
    }

    @Test
    void it_should_return_expected_type_food_when_create_type_food() {
        Mockito.when(typeFoodService.createTypeFood(TYPE_FOOD_DTO))
                .thenReturn(TYPE_FOOD_DTO);

        assertThat(typeFoodController.createTypeFood(TYPE_FOOD_DTO).getBody())
                .isEqualTo(TYPE_FOOD_DTO);
    }

    @Test
    void it_should_return_expected_200_when_create_type_food() {
        Mockito.when(typeFoodService.createTypeFood(TYPE_FOOD_DTO))
                .thenReturn(TYPE_FOOD_DTO);

        assertThat(typeFoodController.createTypeFood(TYPE_FOOD_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_non_null_when_get_type_food_by_id() {
        Mockito.when(typeFoodService.getTypeFoodById(TYPE_FOOD_ID))
                .thenReturn(TYPE_FOOD_DTO);

        assertThat(typeFoodController.getTypeFoodById(TYPE_FOOD_ID))
                .isNotNull();
    }

    @Test
    void it_should_return_expected_type_food_when_get_type_food_by_id() {
        Mockito.when(typeFoodService.getTypeFoodById(TYPE_FOOD_ID))
                .thenReturn(TYPE_FOOD_DTO);

        assertThat(typeFoodController.getTypeFoodById(TYPE_FOOD_ID).getBody())
                .isEqualTo(TYPE_FOOD_DTO);
    }

    @Test
    void it_should_return_expected_200_when_get_type_food_by_id() {
        Mockito.when(typeFoodService.getTypeFoodById(TYPE_FOOD_ID))
                .thenReturn(TYPE_FOOD_DTO);

        assertThat(typeFoodController.getTypeFoodById(TYPE_FOOD_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_non_empty_list_when_get_all_type_foods() {
        Mockito.when(typeFoodService.getAllTypeFoods())
                .thenReturn(Collections.singletonList(TYPE_FOOD_DTO));

        assertThat(typeFoodController.getAllTypeFoods().getBody())
                .isNotEmpty();
    }

    @Test
    void it_should_return_expected_200_when_get_all_type_foods() {
        Mockito.when(typeFoodService.getAllTypeFoods())
                .thenReturn(Collections.singletonList(TYPE_FOOD_DTO));

        assertThat(typeFoodController.getAllTypeFoods().getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_updated_type_food_when_update_type_food() {
        Mockito.when(typeFoodService.updateTypeFood(TYPE_FOOD_ID, TYPE_FOOD_DTO))
                .thenReturn(TYPE_FOOD_DTO);

        assertThat(typeFoodController.updateTypeFood(TYPE_FOOD_ID, TYPE_FOOD_DTO).getBody())
                .isEqualTo(TYPE_FOOD_DTO);
    }

    @Test
    void it_should_return_expected_200_when_update_type_food() {
        Mockito.when(typeFoodService.updateTypeFood(TYPE_FOOD_ID, TYPE_FOOD_DTO))
                .thenReturn(TYPE_FOOD_DTO);

        assertThat(typeFoodController.updateTypeFood(TYPE_FOOD_ID, TYPE_FOOD_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_no_content_when_delete_type_food() {
        Mockito.doNothing().when(typeFoodService).deleteTypeFood(TYPE_FOOD_ID);

        assertThat(typeFoodController.deleteTypeFood(TYPE_FOOD_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Mock
    private TypeFoodService typeFoodService;

    @InjectMocks
    private TypeFoodController typeFoodController;

    private static final Long TYPE_FOOD_ID = 1L;

    private static final TypeFoodDto TYPE_FOOD_DTO = TypeFoodDto.builder()
            .typeFoodId(TYPE_FOOD_ID)
            .type("Italiana")
            .build();
}
