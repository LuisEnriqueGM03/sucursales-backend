package com.empresa.sucursales_api.application.sucursal.port.in;
public interface DeleteSucursalUseCase {
    void deleteSucursal(Long id);
    void deactivateSucursal(Long id);
}
