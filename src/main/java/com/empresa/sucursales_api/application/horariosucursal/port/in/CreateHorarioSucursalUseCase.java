package com.empresa.sucursales_api.application.horariosucursal.port.in;
import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalRequest;
import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalResponse;
public interface CreateHorarioSucursalUseCase {
    HorarioSucursalResponse createHorarioSucursal(HorarioSucursalRequest request);
}
