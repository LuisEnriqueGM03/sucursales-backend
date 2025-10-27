package com.empresa.sucursales_api.domain.telefonopersonal.valueobject;

import lombok.Value;

/**
 * Value Object para el número de teléfono del personal
 */
@Value
public class NumeroTelefono {
    String value;

    public static NumeroTelefono of(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de teléfono es obligatorio");
        }
        String trimmed = numero.trim();
        if (trimmed.length() > 30) {
            throw new IllegalArgumentException("El número no puede exceder 30 caracteres");
        }
        return new NumeroTelefono(trimmed);
    }
}
