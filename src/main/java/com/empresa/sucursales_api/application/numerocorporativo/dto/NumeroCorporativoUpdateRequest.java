package com.empresa.sucursales_api.application.numerocorporativo.dto;
import jakarta.validation.constraints.Size;
public record NumeroCorporativoUpdateRequest(
        @Size(max = 30, message = "El nÃºmero no puede exceder 30 caracteres")
        String numero,
        Long sucursalId,
        Long personalId // null para desasignar
) {
}
