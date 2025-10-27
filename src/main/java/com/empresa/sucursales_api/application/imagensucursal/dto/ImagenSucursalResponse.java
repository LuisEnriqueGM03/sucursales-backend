package com.empresa.sucursales_api.application.imagensucursal.dto;
import lombok.Builder;
import java.time.LocalDateTime;
@Builder
public record ImagenSucursalResponse(
        Long id,
        Long sucursalId,
        String nombreArchivo,
        String rutaArchivo,
        String descripcion,
        LocalDateTime createdAt
) {
}
