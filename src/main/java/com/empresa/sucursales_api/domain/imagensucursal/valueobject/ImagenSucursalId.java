package com.empresa.sucursales_api.domain.imagensucursal.valueobject;

import lombok.Value;

/**
 * Value Object para el identificador único de ImagenSucursal
 */
@Value
public class ImagenSucursalId {
    Long value;

    public static ImagenSucursalId of(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID de la imagen debe ser un valor positivo");
        }
        return new ImagenSucursalId(id);
    }
}
