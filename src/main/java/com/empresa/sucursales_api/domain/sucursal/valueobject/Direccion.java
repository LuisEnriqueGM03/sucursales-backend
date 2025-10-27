package com.empresa.sucursales_api.domain.sucursal.valueobject;
import lombok.Value;
@Value
public class Direccion {
    String value;
    public static Direccion of(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La direcciÃ³n de la sucursal es obligatoria");
        }
        String trimmed = direccion.trim();
        return new Direccion(trimmed);
    }
}
