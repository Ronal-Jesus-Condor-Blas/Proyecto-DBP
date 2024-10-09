package com.proyecto_dbp.proyecto_dbp.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostCreateDto {

    @NotBlank
    @Size(max = 100)
    private String title; // Título del post

    @NotBlank
    @Size(max = 1000)
    private String content; // Contenido del post
}