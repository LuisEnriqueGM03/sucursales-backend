package com.empresa.sucursales_api.domain.telefonopersonal.valueobject;
import lombok.Value;
@Value
public class NumeroTelefono {
    String value;
    public static NumeroTelefono of(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El nÃºmero de telÃ©fono es obligatorio");
        }
        String trimmed = numero.trim();
        if (trimmed.length() > 30) {
            throw new IllegalArgumentException("El nÃºmero no puede exceder 30 caracteres");
        }
        return new NumeroTelefono(trimmed);
    }
}
