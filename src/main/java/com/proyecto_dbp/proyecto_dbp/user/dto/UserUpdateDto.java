package com.proyecto_dbp.proyecto_dbp.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDto {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String profilePicture;
    @NotNull
    private String biography;
}
