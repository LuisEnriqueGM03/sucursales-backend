package com.empresa.sucursales_api.application.contactosucursal.dto;
import lombok.Builder;
@Builder
public record ContactoSucursalResponse(
        Long id,
        Long sucursalId,
        String numero,
        String tipo
) {
}
