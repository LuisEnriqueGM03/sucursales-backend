package com.empresa.sucursales_api.domain.imagensucursal.valueobject;
import lombok.Value;
@Value
public class RutaArchivo {
    String value;
    public static RutaArchivo of(String rutaArchivo) {
        if (rutaArchivo == null || rutaArchivo.trim().isEmpty()) {
            throw new IllegalArgumentException("La ruta del archivo es obligatoria");
        }
        return new RutaArchivo(rutaArchivo.trim());
    }
}
