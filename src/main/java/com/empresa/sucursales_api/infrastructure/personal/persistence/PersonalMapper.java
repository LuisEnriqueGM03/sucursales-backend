package com.empresa.sucursales_api.infrastructure.personal.persistence;
import com.empresa.sucursales_api.domain.personal.model.Personal;
import com.empresa.sucursales_api.domain.personal.valueobject.Cargo;
import com.empresa.sucursales_api.domain.personal.valueobject.CorreoInstitucional;
import com.empresa.sucursales_api.domain.personal.valueobject.NombreCompleto;
import com.empresa.sucursales_api.domain.personal.valueobject.Password;
import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import org.springframework.stereotype.Component;

@Component
public class PersonalMapper {
    public Personal toDomain(PersonalEntity entity) {
        if (entity == null) {
            return null;
        }
        return Personal.builder()
                .id(entity.getId() != null ? PersonalId.of(entity.getId()) : null)
                .nombreCompleto(entity.getNombreCompleto() != null ? NombreCompleto.of(entity.getNombreCompleto()) : null)
                .cargo(entity.getCargo() != null ? Cargo.of(entity.getCargo()) : null)
                .correoInstitucional(entity.getCorreoInstitucional() != null ? CorreoInstitucional.of(entity.getCorreoInstitucional()) : null)
                .password(entity.getPassword() != null ? Password.of(entity.getPassword()) : null)
                .sucursalId(entity.getSucursalId() != null ? SucursalId.of(entity.getSucursalId()) : null)
                .active(entity.getIsActive() != null ? entity.getIsActive() : true)
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
    
    public PersonalEntity toEntity(Personal domain) {
        if (domain == null) {
            return null;
        }
        return PersonalEntity.builder()
                .id(domain.getId() != null ? domain.getId().getValue() : null)
                .nombreCompleto(domain.getNombreCompleto() != null ? domain.getNombreCompleto().getValue() : null)
                .cargo(domain.getCargo() != null ? domain.getCargo().getValue() : null)
                .correoInstitucional(domain.getCorreoInstitucional() != null ? domain.getCorreoInstitucional().getValue() : null)
                .password(domain.getPassword() != null ? domain.getPassword().getHashedValue() : null)
                .sucursalId(domain.getSucursalId() != null ? domain.getSucursalId().getValue() : null)
                .isActive(domain.isActive())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}
