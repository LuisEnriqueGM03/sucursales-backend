package com.empresa.sucursales_api.domain.sucursal.valueobject;

import lombok.Value;

/**
 * Value Object para el teléfono principal de la sucursal
 */
@Value
public class TelefonoPrincipal {
    String value;

    public static TelefonoPrincipal of(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        String trimmed = telefono.trim();
        if (trimmed.length() > 20) {
            throw new IllegalArgumentException("El teléfono no puede exceder 20 caracteres");
        }
        return new TelefonoPrincipal(trimmed);
    }
}
