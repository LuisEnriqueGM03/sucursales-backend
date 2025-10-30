package com.empresa.sucursales_api.application.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    
    private String token;
    private String type;
    private String correoInstitucional;
    private String nombreCompleto;
    private String cargo;
    private Long sucursalId;
}
