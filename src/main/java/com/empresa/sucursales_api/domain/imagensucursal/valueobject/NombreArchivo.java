package com.empresa.sucursales_api.domain.imagensucursal.valueobject;
import lombok.Value;
@Value
public class NombreArchivo {
    String value;
    public static NombreArchivo of(String nombreArchivo) {
        if (nombreArchivo == null || nombreArchivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del archivo es obligatorio");
        }
        String trimmed = nombreArchivo.trim();
        if (trimmed.length() > 255) {
            throw new IllegalArgumentException("El nombre del archivo no puede exceder 255 caracteres");
        }
        return new NombreArchivo(trimmed);
    }
}
