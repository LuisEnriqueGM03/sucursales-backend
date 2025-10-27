package com.empresa.sucursales_api.application.sucursal.port.in;

import com.empresa.sucursales_api.application.sucursal.dto.SucursalResponse;
import com.empresa.sucursales_api.application.sucursal.dto.SucursalUpdateRequest;

/**
 * Puerto de entrada para actualizar una sucursal
 */
public interface UpdateSucursalUseCase {
    SucursalResponse updateSucursal(Long id, SucursalUpdateRequest request);
}
