package com.empresa.sucursales_api.domain.contactosucursal.valueobject;

import lombok.Value;

/**
 * Value Object para el número de contacto de la sucursal
 */
@Value
public class NumeroContacto {
    String value;

    public static NumeroContacto of(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de contacto es obligatorio");
        }
        String trimmed = numero.trim();
        if (trimmed.length() > 30) {
            throw new IllegalArgumentException("El número no puede exceder 30 caracteres");
        }
        return new NumeroContacto(trimmed);
    }
}
