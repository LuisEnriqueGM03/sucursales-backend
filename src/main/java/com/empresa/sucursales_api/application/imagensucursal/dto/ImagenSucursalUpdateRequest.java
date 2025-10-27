package com.empresa.sucursales_api.application.imagensucursal.dto;
import jakarta.validation.constraints.Size;
public record ImagenSucursalUpdateRequest(
        @Size(max = 255, message = "La descripciÃ³n no puede exceder 255 caracteres")
        String descripcion
) {
}
