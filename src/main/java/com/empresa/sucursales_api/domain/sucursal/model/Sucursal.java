package com.empresa.sucursales_api.domain.sucursal.model;

import com.empresa.sucursales_api.domain.contactosucursal.model.ContactoSucursal;
import com.empresa.sucursales_api.domain.horariosucursal.model.HorarioSucursal;
import com.empresa.sucursales_api.domain.sucursal.valueobject.Coordenadas;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.Direccion;
import com.empresa.sucursales_api.domain.sucursal.valueobject.TelefonoPrincipal;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad de dominio que representa una Sucursal
 */
@Value
@Builder
@With
public class Sucursal {
    SucursalId id;
    Direccion direccion;
    TelefonoPrincipal telefonoPrincipal;
    Coordenadas coordenadas;
    List<HorarioSucursal> horarios;
    List<ContactoSucursal> contactos;
    boolean active;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    
}
