package com.empresa.sucursales_api.application.imagensucursal.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public record ImagenSucursalRequest(
        @NotNull(message = "El ID de la sucursal es obligatorio")
        Long sucursalId,
        @Size(max = 255, message = "La descripciÃ³n no puede exceder 255 caracteres")
        String descripcion
) {
}
