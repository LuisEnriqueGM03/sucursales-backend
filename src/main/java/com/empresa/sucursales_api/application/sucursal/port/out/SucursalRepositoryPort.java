package com.empresa.sucursales_api.application.sucursal.port.out;
import com.empresa.sucursales_api.domain.sucursal.model.Sucursal;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import java.util.List;
import java.util.Optional;
public interface SucursalRepositoryPort {
    Sucursal save(Sucursal sucursal);
    Optional<Sucursal> findById(SucursalId id);
    List<Sucursal> findAll();
    List<Sucursal> findByActiveTrue();
    void deleteById(SucursalId id);
    boolean existsById(SucursalId id);
}
