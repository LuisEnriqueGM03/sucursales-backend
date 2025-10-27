package com.empresa.sucursales_api.application.numerocorporativo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO para la creación de un número corporativo
 */
public record NumeroCorporativoRequest(
        @NotBlank(message = "El número corporativo es obligatorio")
        @Size(max = 30, message = "El número no puede exceder 30 caracteres")
        String numero,

        @NotNull(message = "El ID de la sucursal es obligatorio")
        Long sucursalId,

        Long personalId // Opcional - puede ser null
) {
}
