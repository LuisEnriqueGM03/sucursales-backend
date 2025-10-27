package com.empresa.sucursales_api.application.horariosucursal.port.in;

import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalRequest;
import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalResponse;

/**
 * Puerto de entrada para crear un horario de sucursal
 */
public interface CreateHorarioSucursalUseCase {
    HorarioSucursalResponse createHorarioSucursal(HorarioSucursalRequest request);
}
