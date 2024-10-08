package com.proyecto_dbp.proyecto_dbp.comment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentUpdateDto {
    @NotNull
    private String content;
}
