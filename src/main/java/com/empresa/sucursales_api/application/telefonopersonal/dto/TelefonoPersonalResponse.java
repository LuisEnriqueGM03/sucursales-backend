package com.empresa.sucursales_api.application.telefonopersonal.dto;
import lombok.Builder;
@Builder
public record TelefonoPersonalResponse(
        Long id,
        Long personalId,
        String numero,
        String tipo
) {
}
