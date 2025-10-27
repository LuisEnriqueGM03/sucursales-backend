package com.empresa.sucursales_api.application.numerocorporativo.dto;

import lombok.Builder;

import java.time.LocalDateTime;

/**
 * DTO de respuesta para un número corporativo
 */
@Builder
public record NumeroCorporativoResponse(
        Long id,
        String numero,
        Long sucursalId,
        Long personalId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
