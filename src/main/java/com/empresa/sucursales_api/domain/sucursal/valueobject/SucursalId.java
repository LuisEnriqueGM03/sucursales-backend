package com.empresa.sucursales_api.domain.sucursal.valueobject;
import lombok.Value;
@Value
public class SucursalId {
    Long value;
    public static SucursalId of(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID de la sucursal debe ser un nÃºmero positivo");
        }
        return new SucursalId(id);
    }
}
