package com.empresa.sucursales_api.domain.horariosucursal.valueobject;
import lombok.Value;
@Value
public class HorarioSucursalId {
    Long value;
    public static HorarioSucursalId of(Long value) {
        if (value == null) {
            throw new IllegalArgumentException("El ID del horario no puede ser nulo");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("El ID del horario debe ser positivo");
        }
        return new HorarioSucursalId(value);
    }
}
