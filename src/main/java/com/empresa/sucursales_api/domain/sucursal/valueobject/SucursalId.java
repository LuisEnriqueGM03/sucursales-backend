package com.empresa.sucursales_api.domain.sucursal.valueobject;

import lombok.Value;

/**
 * Value Object que representa el identificador de una sucursal
 */
@Value
public class SucursalId {
    Long value;
    
    public static SucursalId of(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID de la sucursal debe ser un número positivo");
        }
        return new SucursalId(id);
    }
}
