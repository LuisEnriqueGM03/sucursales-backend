package com.empresa.sucursales_api.domain.numerocorporativo.model;
import com.empresa.sucursales_api.domain.numerocorporativo.valueobject.Numero;
import com.empresa.sucursales_api.domain.numerocorporativo.valueobject.NumeroCorporativoId;
import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import lombok.Builder;
import lombok.Value;
import lombok.With;
@Value
@Builder
@With
public class NumeroCorporativo {
    NumeroCorporativoId id;
    Numero numero;
    SucursalId sucursalId;
    PersonalId personalId; // Opcional - puede ser null si no estÃ¡ asignado
}
