package com.empresa.sucursales_api.domain.imagensucursal.model;

import com.empresa.sucursales_api.domain.imagensucursal.valueobject.Descripcion;
import com.empresa.sucursales_api.domain.imagensucursal.valueobject.ImagenSucursalId;
import com.empresa.sucursales_api.domain.imagensucursal.valueobject.NombreArchivo;
import com.empresa.sucursales_api.domain.imagensucursal.valueobject.RutaArchivo;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import lombok.Builder;
import lombok.Value;
import lombok.With;

/**
 * Entidad de dominio que representa una Imagen de Sucursal
 */
@Value
@Builder
@With
public class ImagenSucursal {
    ImagenSucursalId id;
    SucursalId sucursalId;
    NombreArchivo nombreArchivo;
    RutaArchivo rutaArchivo;
    Descripcion descripcion;
}
