package com.empresa.sucursales_api.infrastructure.sucursal.persistence;
import com.empresa.sucursales_api.domain.sucursal.model.Sucursal;
import com.empresa.sucursales_api.domain.sucursal.valueobject.Coordenadas;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.Direccion;
import com.empresa.sucursales_api.domain.sucursal.valueobject.TelefonoPrincipal;
import org.springframework.stereotype.Component;
@Component
public class SucursalMapper {
    public Sucursal toDomain(SucursalEntity entity) {
        if (entity == null) {
            return null;
        }
        Coordenadas coordenadas = null;
        if (entity.getLatitud() != null || entity.getLongitud() != null) {
            coordenadas = Coordenadas.of(entity.getLatitud(), entity.getLongitud());
        }
    return Sucursal.builder()
        .id(entity.getId() != null ? SucursalId.of(entity.getId()) : null)
        .nombre(entity.getNombre())
        .direccion(entity.getDireccion() != null ? Direccion.of(entity.getDireccion()) : null)
        .telefonoPrincipal(entity.getTelefonoPrincipal() != null ? TelefonoPrincipal.of(entity.getTelefonoPrincipal()) : null)
        .coordenadas(coordenadas)
        .active(entity.getIsActive() != null ? entity.getIsActive() : true)
        .createdAt(entity.getCreatedAt())
        .updatedAt(entity.getUpdatedAt())
        .build();
    }
    public SucursalEntity toEntity(Sucursal domain) {
        if (domain == null) {
            return null;
        }
        return SucursalEntity.builder()
                .id(domain.getId() != null ? domain.getId().getValue() : null)
                .nombre(domain.getNombre())
        .direccion(domain.getDireccion() != null ? domain.getDireccion().getValue() : null)
        .telefonoPrincipal(domain.getTelefonoPrincipal() != null ? domain.getTelefonoPrincipal().getValue() : null)
                .latitud(domain.getCoordenadas() != null ? domain.getCoordenadas().getLatitud() : null)
                .longitud(domain.getCoordenadas() != null ? domain.getCoordenadas().getLongitud() : null)
                .isActive(domain.isActive())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}
