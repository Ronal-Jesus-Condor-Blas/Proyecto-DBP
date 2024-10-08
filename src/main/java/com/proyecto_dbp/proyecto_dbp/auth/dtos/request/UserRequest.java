package com.proyecto_dbp.proyecto_dbp.auth.dtos.request;

import com.proyecto_dbp.proyecto_dbp.user.domain.UserType;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private UserType userType;
}
