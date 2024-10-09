package com.proyecto_dbp.proyecto_dbp.typefood.domain.services;

import com.proyecto_dbp.proyecto_dbp.typefood.dto.TypeFoodDto;

import java.util.List;

public interface TypeFoodService {
    TypeFoodDto createTypeFood(TypeFoodDto typeFoodDto);
    TypeFoodDto getTypeFoodById(Long id);
    List<TypeFoodDto> getAllTypeFoods();
    TypeFoodDto updateTypeFood(Long id, TypeFoodDto typeFoodDto);
    void deleteTypeFood(Long id);
}