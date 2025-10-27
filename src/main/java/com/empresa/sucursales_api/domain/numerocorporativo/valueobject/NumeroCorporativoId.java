package com.empresa.sucursales_api.domain.numerocorporativo.valueobject;

import lombok.Value;

/**
 * Value Object para el identificador único de NumeroCorporativo
 */
@Value
public class NumeroCorporativoId {
    Long value;

    public static NumeroCorporativoId of(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del número corporativo debe ser un valor positivo");
        }
        return new NumeroCorporativoId(id);
    }
}
