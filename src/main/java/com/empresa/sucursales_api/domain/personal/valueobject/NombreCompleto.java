package com.empresa.sucursales_api.domain.personal.valueobject;
import lombok.Value;
@Value
public class NombreCompleto {
    String value;
    public static NombreCompleto of(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre completo es obligatorio");
        }
        String trimmed = nombre.trim();
        if (trimmed.length() > 150) {
            throw new IllegalArgumentException("El nombre completo no puede exceder 150 caracteres");
        }
        return new NombreCompleto(trimmed);
    }
}
