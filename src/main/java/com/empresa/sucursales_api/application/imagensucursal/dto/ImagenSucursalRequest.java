package com.empresa.sucursales_api.application.imagensucursal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO para la creación de una imagen de sucursal (usado con MultipartFile)
 */
public record ImagenSucursalRequest(
        @NotNull(message = "El ID de la sucursal es obligatorio")
        Long sucursalId,

        @Size(max = 255, message = "La descripción no puede exceder 255 caracteres")
        String descripcion
        
        // El archivo se recibe como MultipartFile en el controlador
) {
}
