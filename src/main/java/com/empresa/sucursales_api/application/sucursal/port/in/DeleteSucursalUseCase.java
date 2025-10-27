package com.empresa.sucursales_api.application.sucursal.port.in;

/**
 * Puerto de entrada para eliminar una sucursal
 */
public interface DeleteSucursalUseCase {
    void deleteSucursal(Long id);
    void deactivateSucursal(Long id);
}
