package com.empresa.sucursales_api.domain.numerocorporativo.valueobject;
import lombok.Value;
@Value
public class NumeroCorporativoId {
    Long value;
    public static NumeroCorporativoId of(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del nÃºmero corporativo debe ser un valor positivo");
        }
        return new NumeroCorporativoId(id);
    }
}
