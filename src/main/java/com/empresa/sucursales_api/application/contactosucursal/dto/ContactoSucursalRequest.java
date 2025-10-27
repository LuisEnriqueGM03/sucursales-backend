package com.empresa.sucursales_api.application.contactosucursal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO para la creación de un contacto de sucursal
 */
public record ContactoSucursalRequest(
        @NotNull(message = "El ID de la sucursal es obligatorio")
        Long sucursalId,

        @NotBlank(message = "El número de contacto es obligatorio")
        @Size(max = 30, message = "El número no puede exceder 30 caracteres")
        String numero,

        @NotBlank(message = "El tipo de contacto es obligatorio")
        @Size(max = 30, message = "El tipo no puede exceder 30 caracteres")
        String tipo
) {
}
