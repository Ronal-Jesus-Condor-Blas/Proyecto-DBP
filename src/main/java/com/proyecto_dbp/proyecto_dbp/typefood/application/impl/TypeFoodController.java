package com.proyecto_dbp.proyecto_dbp.typefood.application.impl;

import com.proyecto_dbp.proyecto_dbp.typefood.application.TypeFoodApi;
import com.proyecto_dbp.proyecto_dbp.typefood.domain.services.TypeFoodService;
import com.proyecto_dbp.proyecto_dbp.typefood.dto.TypeFoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeFoodController implements TypeFoodApi {

    @Autowired
    private TypeFoodService typeFoodService;

    @Override
    public TypeFoodDto createTypeFood(TypeFoodDto typeFoodDto) {
        return typeFoodService.createTypeFood(typeFoodDto);
    }

    @Override
    public TypeFoodDto getTypeFoodById(Long id) {
        return typeFoodService.getTypeFoodById(id);
    }

    @Override
    public List<TypeFoodDto> getAllTypeFoods() {
        return typeFoodService.getAllTypeFoods();
    }

    @Override
    public TypeFoodDto updateTypeFood(Long id, TypeFoodDto typeFoodDto) {
        return typeFoodService.updateTypeFood(id, typeFoodDto);
    }

    @Override
    public void deleteTypeFood(Long id) {
        typeFoodService.deleteTypeFood(id);
    }
}