package com.empresa.sucursales_api.application.sucursal.port.in;
import com.empresa.sucursales_api.application.sucursal.dto.SucursalResponse;
import java.util.List;
public interface GetSucursalUseCase {
    SucursalResponse getSucursalById(Long id);
    List<SucursalResponse> getAllSucursales();
    List<SucursalResponse> getActiveSucursales();
}
