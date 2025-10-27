package com.empresa.sucursales_api.infrastructure.horariosucursal.persistence;

import com.empresa.sucursales_api.domain.horariosucursal.model.HorarioSucursal;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.DiaSemana;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.HoraApertura;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.HoraCierre;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.HorarioSucursalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;

/**
 * Mapper para convertir entre HorarioSucursal (dominio) y HorarioSucursalEntity (infraestructura)
 */
public class HorarioSucursalMapper {
    
    /**
     * Convierte una entidad JPA a modelo de dominio
     */
    public HorarioSucursal toDomain(HorarioSucursalEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return HorarioSucursal.builder()
                .id(entity.getId() != null ? HorarioSucursalId.of(entity.getId()) : null)
                .sucursalId(entity.getSucursalId() != null ? SucursalId.of(entity.getSucursalId()) : null)
                .diaSemana(entity.getDiaSemana() != null ? DiaSemana.fromString(entity.getDiaSemana()) : null)
                .horaApertura(entity.getHoraApertura() != null ? HoraApertura.of(entity.getHoraApertura()) : null)
                .horaCierre(entity.getHoraCierre() != null ? HoraCierre.of(entity.getHoraCierre()) : null)
                .build();
    }
    
    /**
     * Convierte un modelo de dominio a entidad JPA
     */
    public HorarioSucursalEntity toEntity(HorarioSucursal horario) {
        if (horario == null) {
            return null;
        }
        
        return HorarioSucursalEntity.builder()
                .id(horario.getId() != null ? horario.getId().getValue() : null)
                .sucursalId(horario.getSucursalId() != null ? horario.getSucursalId().getValue() : null)
                .diaSemana(horario.getDiaSemana() != null ? horario.getDiaSemana().getNombre() : null)
                .horaApertura(horario.getHoraApertura() != null ? horario.getHoraApertura().getValue() : null)
                .horaCierre(horario.getHoraCierre() != null ? horario.getHoraCierre().getValue() : null)
                .build();
    }
}
