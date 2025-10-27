package com.empresa.sucursales_api.domain.contactosucursal.model;

import com.empresa.sucursales_api.domain.contactosucursal.valueobject.ContactoSucursalId;
import com.empresa.sucursales_api.domain.contactosucursal.valueobject.NumeroContacto;
import com.empresa.sucursales_api.domain.contactosucursal.valueobject.TipoContacto;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import lombok.Builder;
import lombok.Value;
import lombok.With;

/**
 * Entidad de dominio que representa un Contacto de Sucursal
 */
@Value
@Builder
@With
public class ContactoSucursal {
    ContactoSucursalId id;
    SucursalId sucursalId;
    NumeroContacto numero;
    TipoContacto tipo;
}
