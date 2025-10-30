package com.empresa.sucursales_api.application.personal.dto;
import com.empresa.sucursales_api.application.telefonopersonal.dto.TelefonoPersonalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalResponse {
    private Long id;
    private String nombreCompleto;
    private String cargo; // Retorna el displayName del enum (Admin, Gerente, etc.)
    private String correoInstitucional;
    private Long sucursalId;
    private List<TelefonoPersonalResponse> telefonos;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // Nota: El password NO se incluye en la respuesta por seguridad
}
