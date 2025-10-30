package com.empresa.sucursales_api.application.personal.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalUpdateRequest {
    @Size(max = 150, message = "El nombre completo no puede exceder 150 caracteres")
    private String nombreCompleto;
    
    @Size(max = 50, message = "El cargo no puede exceder 50 caracteres")
    private String cargo; // Valores permitidos: ADMIN, GERENTE, ENCARGADO, PERSONAL
    
    @Email(message = "El correo institucional debe tener un formato válido")
    @Size(max = 150, message = "El correo no puede exceder 150 caracteres")
    private String correoInstitucional;
    
    @Size(min = 6, max = 100, message = "El password debe tener entre 6 y 100 caracteres")
    private String password; // Opcional: solo se actualiza si se proporciona
    
    private Long sucursalId;
    private Boolean active;
}
