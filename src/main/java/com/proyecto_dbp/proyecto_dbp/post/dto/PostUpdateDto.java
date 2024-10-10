package com.proyecto_dbp.proyecto_dbp.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostUpdateDto {

    @NotBlank
    @Size(max = 100)
    private String title; // Título del post

    @NotBlank
    @Size(max = 1000)
    private String content; // Contenido del post
}
