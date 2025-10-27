package com.empresa.sucursales_api.domain.numerocorporativo.valueobject;
import lombok.Value;
@Value
public class Numero {
    String value;
    public static Numero of(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El nÃºmero corporativo es obligatorio");
        }
        String trimmed = numero.trim();
        if (trimmed.length() > 30) {
            throw new IllegalArgumentException("El nÃºmero no puede exceder 30 caracteres");
        }
        return new Numero(trimmed);
    }
}
