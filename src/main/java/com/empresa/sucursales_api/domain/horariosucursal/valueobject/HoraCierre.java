package com.empresa.sucursales_api.domain.horariosucursal.valueobject;
import lombok.Value;
import java.time.LocalTime;
@Value
public class HoraCierre {
    LocalTime value;
    public static HoraCierre of(LocalTime value) {
        if (value == null) {
            throw new IllegalArgumentException("La hora de cierre no puede ser nula");
        }
        return new HoraCierre(value);
    }
    public void validateDespuesDe(HoraApertura horaApertura) {
        if (horaApertura != null && !value.isAfter(horaApertura.getValue())) {
            throw new IllegalArgumentException(
                    "La hora de cierre (" + value + ") debe ser posterior a la hora de apertura (" + 
                    horaApertura.getValue() + ")");
        }
    }
}
