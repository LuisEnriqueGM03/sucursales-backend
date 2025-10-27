package com.empresa.sucursales_api.infrastructure.imagensucursal.persistence;

import com.empresa.sucursales_api.domain.imagensucursal.model.ImagenSucursal;
import com.empresa.sucursales_api.domain.imagensucursal.valueobject.Descripcion;
import com.empresa.sucursales_api.domain.imagensucursal.valueobject.ImagenSucursalId;
import com.empresa.sucursales_api.domain.imagensucursal.valueobject.NombreArchivo;
import com.empresa.sucursales_api.domain.imagensucursal.valueobject.RutaArchivo;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre ImagenSucursalEntity y ImagenSucursal (domain model)
 */
@Component
public class ImagenSucursalMapper {
    
    public ImagenSucursal toDomain(ImagenSucursalEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return ImagenSucursal.builder()
                .id(entity.getId() != null ? ImagenSucursalId.of(entity.getId()) : null)
                .sucursalId(entity.getSucursalId() != null ? SucursalId.of(entity.getSucursalId()) : null)
                .nombreArchivo(entity.getNombreArchivo() != null ? NombreArchivo.of(entity.getNombreArchivo()) : null)
                .rutaArchivo(entity.getRutaArchivo() != null ? RutaArchivo.of(entity.getRutaArchivo()) : null)
                .descripcion(Descripcion.of(entity.getDescripcion()))
                .build();
    }
    
    public ImagenSucursalEntity toEntity(ImagenSucursal domain) {
        if (domain == null) {
            return null;
        }
        
        return ImagenSucursalEntity.builder()
                .id(domain.getId() != null ? domain.getId().getValue() : null)
                .sucursalId(domain.getSucursalId() != null ? domain.getSucursalId().getValue() : null)
                .nombreArchivo(domain.getNombreArchivo() != null ? domain.getNombreArchivo().getValue() : null)
                .rutaArchivo(domain.getRutaArchivo() != null ? domain.getRutaArchivo().getValue() : null)
                .descripcion(domain.getDescripcion() != null ? domain.getDescripcion().getValue() : null)
                .build();
    }
}
