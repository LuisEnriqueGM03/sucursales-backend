package com.empresa.sucursales_api.application.telefonopersonal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para la actualización de un teléfono del personal
 */
public record TelefonoPersonalUpdateRequest(
        @NotBlank(message = "El número de teléfono es obligatorio")
        @Size(max = 30, message = "El número no puede exceder 30 caracteres")
        String numero,

        @Size(max = 30, message = "El tipo no puede exceder 30 caracteres")
        String tipo
) {
}
