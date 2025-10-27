package com.empresa.sucursales_api.domain.contactosucursal.valueobject;

import lombok.Value;

/**
 * Value Object para el tipo de contacto de la sucursal
 */
@Value
public class TipoContacto {
    String value;

    public static TipoContacto of(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de contacto es obligatorio");
        }
        String trimmed = tipo.trim();
        if (trimmed.length() > 30) {
            throw new IllegalArgumentException("El tipo no puede exceder 30 caracteres");
        }
        return new TipoContacto(trimmed);
    }
}