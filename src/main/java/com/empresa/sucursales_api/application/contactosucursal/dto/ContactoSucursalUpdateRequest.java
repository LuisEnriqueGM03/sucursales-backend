package com.empresa.sucursales_api.application.contactosucursal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para la actualización de un contacto de sucursal
 */
public record ContactoSucursalUpdateRequest(
        @NotBlank(message = "El número de contacto es obligatorio")
        @Size(max = 30, message = "El número no puede exceder 30 caracteres")
        String numero,

        @Size(max = 30, message = "El tipo no puede exceder 30 caracteres")
        String tipo
) {
}
