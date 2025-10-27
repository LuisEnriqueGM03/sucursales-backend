package com.empresa.sucursales_api.domain.telefonopersonal.model;

import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import com.empresa.sucursales_api.domain.telefonopersonal.valueobject.NumeroTelefono;
import com.empresa.sucursales_api.domain.telefonopersonal.valueobject.TelefonoPersonalId;
import com.empresa.sucursales_api.domain.telefonopersonal.valueobject.TipoTelefono;
import lombok.Builder;
import lombok.Value;
import lombok.With;

/**
 * Entidad de dominio que representa un Teléfono del Personal
 */
@Value
@Builder
@With
public class TelefonoPersonal {
    TelefonoPersonalId id;
    PersonalId personalId;
    NumeroTelefono numero;
    TipoTelefono tipo;
}
