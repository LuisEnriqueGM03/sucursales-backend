package com.empresa.sucursales_api.application.numerocorporativo.dto;

import jakarta.validation.constraints.Size;

/**
 * DTO para la actualización de un número corporativo
 */
public record NumeroCorporativoUpdateRequest(
        @Size(max = 30, message = "El número no puede exceder 30 caracteres")
        String numero,

        Long sucursalId,

        Long personalId // null para desasignar
) {
}
