package com.empresa.sucursales_api.domain.personal.valueobject;
import lombok.Value;
@Value
public class CorreoInstitucional {
    String value;
    public static CorreoInstitucional of(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo institucional es obligatorio");
        }
        String trimmed = correo.trim();
        if (trimmed.length() > 150) {
            throw new IllegalArgumentException("El correo no puede exceder 150 caracteres");
        }
        if (!trimmed.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("El correo institucional no tiene un formato vÃ¡lido");
        }
        return new CorreoInstitucional(trimmed.toLowerCase());
    }
}
