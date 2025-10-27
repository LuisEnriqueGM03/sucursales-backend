package com.empresa.sucursales_api.application.personal.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalResponse {
    private Long id;
    private String nombreCompleto;
    private String cargo;
    private String correoInstitucional;
    private Long sucursalId;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
