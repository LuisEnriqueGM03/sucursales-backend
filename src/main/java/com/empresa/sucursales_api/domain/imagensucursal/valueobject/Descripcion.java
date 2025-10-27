package com.empresa.sucursales_api.domain.imagensucursal.valueobject;

import lombok.Value;

/**
 * Value Object para la descripción de la imagen
 */
@Value
public class Descripcion {
    String value;

    public static Descripcion of(String descripcion) {
        if (descripcion == null) {
            return new Descripcion(null);
        }
        String trimmed = descripcion.trim();
        if (trimmed.isEmpty()) {
            return new Descripcion(null);
        }
        if (trimmed.length() > 255) {
            throw new IllegalArgumentException("La descripción no puede exceder 255 caracteres");
        }
        return new Descripcion(trimmed);
    }
}
