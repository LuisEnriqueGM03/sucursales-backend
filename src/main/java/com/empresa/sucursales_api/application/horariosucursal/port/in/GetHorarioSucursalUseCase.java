package com.empresa.sucursales_api.application.horariosucursal.port.in;

import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalResponse;

import java.util.List;

/**
 * Puerto de entrada para consultar horarios de sucursal
 */
public interface GetHorarioSucursalUseCase {
    HorarioSucursalResponse getHorarioSucursalById(Long id);
    List<HorarioSucursalResponse> getAllHorariosSucursales();
    List<HorarioSucursalResponse> getHorariosBySucursalId(Long sucursalId);
}
