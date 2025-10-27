package com.empresa.sucursales_api.infrastructure.contactosucursal.persistence;
import com.empresa.sucursales_api.domain.contactosucursal.model.ContactoSucursal;
import com.empresa.sucursales_api.domain.contactosucursal.valueobject.ContactoSucursalId;
import com.empresa.sucursales_api.domain.contactosucursal.valueobject.NumeroContacto;
import com.empresa.sucursales_api.domain.contactosucursal.valueobject.TipoContacto;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import org.springframework.stereotype.Component;
@Component
public class ContactoSucursalMapper {
    public ContactoSucursal toDomain(ContactoSucursalEntity entity) {
        if (entity == null) {
            return null;
        }
        return ContactoSucursal.builder()
                .id(entity.getId() != null ? ContactoSucursalId.of(entity.getId()) : null)
                .sucursalId(entity.getSucursalId() != null ? SucursalId.of(entity.getSucursalId()) : null)
                .numero(entity.getNumero() != null ? NumeroContacto.of(entity.getNumero()) : null)
                .tipo(entity.getTipo() != null ? TipoContacto.of(entity.getTipo()) : null)
                .build();
    }
    public ContactoSucursalEntity toEntity(ContactoSucursal domain) {
        if (domain == null) {
            return null;
        }
        return ContactoSucursalEntity.builder()
                .id(domain.getId() != null ? domain.getId().getValue() : null)
                .sucursalId(domain.getSucursalId() != null ? domain.getSucursalId().getValue() : null)
                .numero(domain.getNumero() != null ? domain.getNumero().getValue() : null)
                .tipo(domain.getTipo() != null ? domain.getTipo().getValue() : null)
                .build();
    }
}
