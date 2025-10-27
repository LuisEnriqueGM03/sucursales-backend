package com.empresa.sucursales_api.application.horariosucursal.port.out;
import com.empresa.sucursales_api.domain.horariosucursal.model.HorarioSucursal;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.HorarioSucursalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import java.util.List;
import java.util.Optional;
public interface HorarioSucursalRepositoryPort {
    HorarioSucursal save(HorarioSucursal horarioSucursal);
    Optional<HorarioSucursal> findById(HorarioSucursalId id);
    List<HorarioSucursal> findAll();
    List<HorarioSucursal> findBySucursalId(SucursalId sucursalId);
    boolean existsById(HorarioSucursalId id);
    void deleteById(HorarioSucursalId id);
}
