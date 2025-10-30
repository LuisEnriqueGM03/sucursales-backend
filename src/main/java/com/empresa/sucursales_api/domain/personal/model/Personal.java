package com.empresa.sucursales_api.domain.personal.model;
import com.empresa.sucursales_api.domain.personal.valueobject.Cargo;
import com.empresa.sucursales_api.domain.personal.valueobject.CorreoInstitucional;
import com.empresa.sucursales_api.domain.personal.valueobject.NombreCompleto;
import com.empresa.sucursales_api.domain.personal.valueobject.Password;
import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import com.empresa.sucursales_api.domain.telefonopersonal.model.TelefonoPersonal;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
@With
public class Personal {
    PersonalId id;
    NombreCompleto nombreCompleto;
    Cargo cargo;
    CorreoInstitucional correoInstitucional;
    Password password;
    SucursalId sucursalId;
    List<TelefonoPersonal> telefonos;
    boolean active;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
