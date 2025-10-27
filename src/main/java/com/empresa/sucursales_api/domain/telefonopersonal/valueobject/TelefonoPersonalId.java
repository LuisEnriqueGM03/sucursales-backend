package com.empresa.sucursales_api.domain.telefonopersonal.valueobject;

import lombok.Value;

/**
 * Value Object para el identificador único de TelefonoPersonal
 */
@Value
public class TelefonoPersonalId {
    Long value;

    public static TelefonoPersonalId of(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del teléfono debe ser un valor positivo");
        }
        return new TelefonoPersonalId(id);
    }
}
