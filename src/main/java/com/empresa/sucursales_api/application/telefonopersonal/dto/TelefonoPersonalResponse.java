package com.empresa.sucursales_api.application.telefonopersonal.dto;

import lombok.Builder;

/**
 * DTO de respuesta para un teléfono del personal
 */
@Builder
public record TelefonoPersonalResponse(
        Long id,
        Long personalId,
        String numero,
        String tipo
) {
}
