package com.empresa.sucursales_api.application.horariosucursal.port.in;

/**
 * Puerto de entrada para eliminar un horario de sucursal
 */
public interface DeleteHorarioSucursalUseCase {
    void deleteHorarioSucursal(Long id);
}
