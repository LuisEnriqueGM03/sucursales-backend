package com.empresa.sucursales_api.domain.sucursal.valueobject;
import lombok.Value;
import java.math.BigDecimal;
@Value
public class Coordenadas {
    BigDecimal latitud;
    BigDecimal longitud;
    public static Coordenadas of(BigDecimal latitud, BigDecimal longitud) {
        if (latitud != null && (latitud.compareTo(BigDecimal.valueOf(-90)) < 0 || 
                                latitud.compareTo(BigDecimal.valueOf(90)) > 0)) {
            throw new IllegalArgumentException("La latitud debe estar entre -90 y 90");
        }
        if (longitud != null && (longitud.compareTo(BigDecimal.valueOf(-180)) < 0 || 
                                  longitud.compareTo(BigDecimal.valueOf(180)) > 0)) {
            throw new IllegalArgumentException("La longitud debe estar entre -180 y 180");
        }
        return new Coordenadas(latitud, longitud);
    }
}
