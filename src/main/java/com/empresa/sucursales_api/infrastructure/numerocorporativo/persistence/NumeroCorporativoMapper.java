package com.empresa.sucursales_api.infrastructure.numerocorporativo.persistence;
import com.empresa.sucursales_api.domain.numerocorporativo.model.NumeroCorporativo;
import com.empresa.sucursales_api.domain.numerocorporativo.valueobject.Numero;
import com.empresa.sucursales_api.domain.numerocorporativo.valueobject.NumeroCorporativoId;
import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import org.springframework.stereotype.Component;
@Component
public class NumeroCorporativoMapper {
    public NumeroCorporativo toDomain(NumeroCorporativoEntity entity) {
        if (entity == null) {
            return null;
        }
        return NumeroCorporativo.builder()
                .id(entity.getId() != null ? NumeroCorporativoId.of(entity.getId()) : null)
                .numero(entity.getNumero() != null ? Numero.of(entity.getNumero()) : null)
                .sucursalId(entity.getSucursalId() != null ? SucursalId.of(entity.getSucursalId()) : null)
                .personalId(entity.getPersonalId() != null ? PersonalId.of(entity.getPersonalId()) : null)
                .build();
    }
    public NumeroCorporativoEntity toEntity(NumeroCorporativo domain) {
        if (domain == null) {
            return null;
        }
        return NumeroCorporativoEntity.builder()
                .id(domain.getId() != null ? domain.getId().getValue() : null)
                .numero(domain.getNumero() != null ? domain.getNumero().getValue() : null)
                .sucursalId(domain.getSucursalId() != null ? domain.getSucursalId().getValue() : null)
                .personalId(domain.getPersonalId() != null ? domain.getPersonalId().getValue() : null)
                .build();
    }
}
