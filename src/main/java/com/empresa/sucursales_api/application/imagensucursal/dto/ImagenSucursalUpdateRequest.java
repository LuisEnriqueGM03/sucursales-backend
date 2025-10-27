package com.empresa.sucursales_api.application.imagensucursal.dto;

import jakarta.validation.constraints.Size;

/**
 * DTO para la actualización de una imagen de sucursal (solo descripción)
 */
public record ImagenSucursalUpdateRequest(
        @Size(max = 255, message = "La descripción no puede exceder 255 caracteres")
        String descripcion
) {
}
