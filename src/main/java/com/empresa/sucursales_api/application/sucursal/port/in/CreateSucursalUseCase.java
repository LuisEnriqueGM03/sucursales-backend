package com.empresa.sucursales_api.application.sucursal.port.in;
import com.empresa.sucursales_api.application.sucursal.dto.SucursalRequest;
import com.empresa.sucursales_api.application.sucursal.dto.SucursalResponse;
public interface CreateSucursalUseCase {
    SucursalResponse createSucursal(SucursalRequest request);
}
