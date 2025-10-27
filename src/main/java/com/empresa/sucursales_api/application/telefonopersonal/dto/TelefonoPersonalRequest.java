package com.empresa.sucursales_api.application.telefonopersonal.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public record TelefonoPersonalRequest(
        @NotNull(message = "El ID del personal es obligatorio")
        Long personalId,
        @NotBlank(message = "El nÃºmero de telÃ©fono es obligatorio")
        @Size(max = 30, message = "El nÃºmero no puede exceder 30 caracteres")
        String numero,
        @Size(max = 30, message = "El tipo no puede exceder 30 caracteres")
        String tipo // Ej: personal, alternativo, emergencia - default: "personal"
) {
}
