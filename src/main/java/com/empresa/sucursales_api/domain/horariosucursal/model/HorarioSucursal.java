package com.empresa.sucursales_api.domain.horariosucursal.model;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.DiaSemana;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.HoraApertura;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.HoraCierre;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.HorarioSucursalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import lombok.Builder;
import lombok.Value;
import lombok.With;
@Value
@Builder
@With
public class HorarioSucursal {
    HorarioSucursalId id;
    SucursalId sucursalId;
    DiaSemana diaSemana;
    HoraApertura horaApertura;
    HoraCierre horaCierre;
    public void validate() {
        if (horaApertura != null && horaCierre != null) {
            horaApertura.validateAntesQue(horaCierre);
            horaCierre.validateDespuesDe(horaApertura);
        }
    }
}
