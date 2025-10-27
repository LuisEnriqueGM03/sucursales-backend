package com.empresa.sucursales_api.domain.telefonopersonal.valueobject;
import lombok.Value;
@Value
public class TipoTelefono {
    String value;
    public static TipoTelefono of(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            return new TipoTelefono("personal"); // Valor por defecto
        }
        String trimmed = tipo.trim();
        if (trimmed.length() > 30) {
            throw new IllegalArgumentException("El tipo no puede exceder 30 caracteres");
        }
        return new TipoTelefono(trimmed);
    }
}
