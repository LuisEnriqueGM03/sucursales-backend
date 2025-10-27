package com.empresa.sucursales_api.application.horariosucursal.port.in;

import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalResponse;
import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalUpdateRequest;

/**
 * Puerto de entrada para actualizar un horario de sucursal
 */
public interface UpdateHorarioSucursalUseCase {
    HorarioSucursalResponse updateHorarioSucursal(Long id, HorarioSucursalUpdateRequest request);
}
