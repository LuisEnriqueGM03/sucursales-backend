package com.empresa.sucursales_api.domain.personal.model;

import com.empresa.sucursales_api.domain.personal.valueobject.Cargo;
import com.empresa.sucursales_api.domain.personal.valueobject.CorreoInstitucional;
import com.empresa.sucursales_api.domain.personal.valueobject.NombreCompleto;
import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.LocalDateTime;

/**
 * Entidad de dominio que representa un Personal
 */
@Value
@Builder
@With
public class Personal {
    PersonalId id;
    NombreCompleto nombreCompleto;
    Cargo cargo;
    CorreoInstitucional correoInstitucional;
    SucursalId sucursalId;
    boolean active;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
