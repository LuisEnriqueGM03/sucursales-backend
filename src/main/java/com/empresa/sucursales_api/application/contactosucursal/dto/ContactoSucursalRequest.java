package com.empresa.sucursales_api.application.contactosucursal.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public record ContactoSucursalRequest(
        @NotNull(message = "El ID de la sucursal es obligatorio")
        Long sucursalId,
        @NotBlank(message = "El nÃºmero de contacto es obligatorio")
        @Size(max = 30, message = "El nÃºmero no puede exceder 30 caracteres")
        String numero,
        @NotBlank(message = "El tipo de contacto es obligatorio")
        @Size(max = 30, message = "El tipo no puede exceder 30 caracteres")
        String tipo
) {
}
