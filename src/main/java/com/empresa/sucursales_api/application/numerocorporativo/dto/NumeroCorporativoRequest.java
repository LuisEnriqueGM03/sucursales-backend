package com.empresa.sucursales_api.application.numerocorporativo.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public record NumeroCorporativoRequest(
        @NotBlank(message = "El nÃºmero corporativo es obligatorio")
        @Size(max = 30, message = "El nÃºmero no puede exceder 30 caracteres")
        String numero,
        @NotNull(message = "El ID de la sucursal es obligatorio")
        Long sucursalId,
        Long personalId // Opcional - puede ser null
) {
}
