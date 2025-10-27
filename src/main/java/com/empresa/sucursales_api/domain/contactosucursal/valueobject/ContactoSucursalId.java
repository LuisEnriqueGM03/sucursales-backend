package com.empresa.sucursales_api.domain.contactosucursal.valueobject;

import lombok.Value;

/**
 * Value Object para el identificador del contacto de sucursal
 */
@Value(staticConstructor = "of")
public class ContactoSucursalId {
    Long value;
}
