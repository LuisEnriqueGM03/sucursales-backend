package com.empresa.sucursales_api.application.contactosucursal.dto;

import lombok.Builder;

/**
 * DTO de respuesta para un contacto de sucursal
 */
@Builder
public record ContactoSucursalResponse(
        Long id,
        Long sucursalId,
        String numero,
        String tipo
) {
}
