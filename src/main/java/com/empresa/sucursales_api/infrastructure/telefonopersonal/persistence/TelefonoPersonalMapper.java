package com.empresa.sucursales_api.infrastructure.telefonopersonal.persistence;
import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import com.empresa.sucursales_api.domain.telefonopersonal.model.TelefonoPersonal;
import com.empresa.sucursales_api.domain.telefonopersonal.valueobject.NumeroTelefono;
import com.empresa.sucursales_api.domain.telefonopersonal.valueobject.TelefonoPersonalId;
import com.empresa.sucursales_api.domain.telefonopersonal.valueobject.TipoTelefono;
import org.springframework.stereotype.Component;
@Component
public class TelefonoPersonalMapper {
    public TelefonoPersonal toDomain(TelefonoPersonalEntity entity) {
        if (entity == null) {
            return null;
        }
        return TelefonoPersonal.builder()
                .id(entity.getId() != null ? TelefonoPersonalId.of(entity.getId()) : null)
                .personalId(entity.getPersonalId() != null ? PersonalId.of(entity.getPersonalId()) : null)
                .numero(entity.getNumero() != null ? NumeroTelefono.of(entity.getNumero()) : null)
                .tipo(entity.getTipo() != null ? TipoTelefono.of(entity.getTipo()) : TipoTelefono.of("personal"))
                .build();
    }
    public TelefonoPersonalEntity toEntity(TelefonoPersonal domain) {
        if (domain == null) {
            return null;
        }
        return TelefonoPersonalEntity.builder()
                .id(domain.getId() != null ? domain.getId().getValue() : null)
                .personalId(domain.getPersonalId() != null ? domain.getPersonalId().getValue() : null)
                .numero(domain.getNumero() != null ? domain.getNumero().getValue() : null)
                .tipo(domain.getTipo() != null ? domain.getTipo().getValue() : "personal")
                .build();
    }
}
