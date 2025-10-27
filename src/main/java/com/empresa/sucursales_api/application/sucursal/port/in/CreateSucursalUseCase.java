package com.empresa.sucursales_api.application.sucursal.port.in;

import com.empresa.sucursales_api.application.sucursal.dto.SucursalRequest;
import com.empresa.sucursales_api.application.sucursal.dto.SucursalResponse;

/**
 * Puerto de entrada para crear una nueva sucursal
 */
public interface CreateSucursalUseCase {
    SucursalResponse createSucursal(SucursalRequest request);
}
