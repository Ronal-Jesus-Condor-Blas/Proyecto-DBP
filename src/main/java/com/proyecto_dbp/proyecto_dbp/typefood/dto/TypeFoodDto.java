package com.proyecto_dbp.proyecto_dbp.typefood.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeFoodDto {
    private Long typeFoodId;
    private String type;
}
