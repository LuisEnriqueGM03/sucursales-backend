package com.empresa.sucursales_api.domain.numerocorporativo.valueobject;

import lombok.Value;

/**
 * Value Object para el número corporativo (debe ser único)
 */
@Value
public class Numero {
    String value;

    public static Numero of(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El número corporativo es obligatorio");
        }
        String trimmed = numero.trim();
        if (trimmed.length() > 30) {
            throw new IllegalArgumentException("El número no puede exceder 30 caracteres");
        }
        return new Numero(trimmed);
    }
}
