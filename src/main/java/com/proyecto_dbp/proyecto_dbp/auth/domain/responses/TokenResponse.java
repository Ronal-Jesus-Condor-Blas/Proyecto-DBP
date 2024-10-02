package com.proyecto_dbp.proyecto_dbp.auth.domain.responses;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class TokenResponse {
    private String accessToken;
}
