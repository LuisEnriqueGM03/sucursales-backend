package com.empresa.sucursales_api.domain.personal.valueobject;

import lombok.Value;

/**
 * Value Object para el cargo del personal
 */
@Value
public class Cargo {
    String value;

    public static Cargo of(String cargo) {
        if (cargo != null) {
            String trimmed = cargo.trim();
            if (trimmed.length() > 100) {
                throw new IllegalArgumentException("El cargo no puede exceder 100 caracteres");
            }
            return new Cargo(trimmed.isEmpty() ? null : trimmed);
        }
        return new Cargo(null);
    }
}
