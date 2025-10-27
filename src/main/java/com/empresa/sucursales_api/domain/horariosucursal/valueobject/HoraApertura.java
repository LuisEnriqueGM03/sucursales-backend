package com.empresa.sucursales_api.domain.horariosucursal.valueobject;
import lombok.Value;
import java.time.LocalTime;
@Value
public class HoraApertura {
    LocalTime value;
    public static HoraApertura of(LocalTime value) {
        if (value == null) {
            throw new IllegalArgumentException("La hora de apertura no puede ser nula");
        }
        return new HoraApertura(value);
    }
    public void validateAntesQue(HoraCierre horaCierre) {
        if (horaCierre != null && !value.isBefore(horaCierre.getValue())) {
            throw new IllegalArgumentException(
                    "La hora de apertura (" + value + ") debe ser anterior a la hora de cierre (" + 
                    horaCierre.getValue() + ")");
        }
    }
}
