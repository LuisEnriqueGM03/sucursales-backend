package com.empresa.sucursales_api.application.personal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para la actualización de un personal
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalUpdateRequest {
    
    @Size(max = 150, message = "El nombre completo no puede exceder 150 caracteres")
    private String nombreCompleto;
    
    @Size(max = 100, message = "El cargo no puede exceder 100 caracteres")
    private String cargo;
    
    @Email(message = "El correo institucional debe tener un formato válido")
    @Size(max = 150, message = "El correo no puede exceder 150 caracteres")
    private String correoInstitucional;
    
    private Long sucursalId;
    
    private Boolean active;
}
