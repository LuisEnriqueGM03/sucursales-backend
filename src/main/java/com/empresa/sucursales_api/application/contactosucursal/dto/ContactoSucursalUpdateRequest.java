package com.empresa.sucursales_api.application.contactosucursal.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public record ContactoSucursalUpdateRequest(
        @NotBlank(message = "El nÃºmero de contacto es obligatorio")
        @Size(max = 30, message = "El nÃºmero no puede exceder 30 caracteres")
        String numero,
        @Size(max = 30, message = "El tipo no puede exceder 30 caracteres")
        String tipo
) {
}
