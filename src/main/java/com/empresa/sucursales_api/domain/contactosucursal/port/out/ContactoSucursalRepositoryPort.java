package com.empresa.sucursales_api.domain.contactosucursal.port.out;

import com.empresa.sucursales_api.domain.contactosucursal.model.ContactoSucursal;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para operaciones de persistencia de ContactoSucursal
 */
public interface ContactoSucursalRepositoryPort {
    ContactoSucursal save(ContactoSucursal contacto);
    Optional<ContactoSucursal> findById(Long id);
    List<ContactoSucursal> findAll();
    List<ContactoSucursal> findBySucursalId(Long sucursalId);
    void deleteById(Long id);
    boolean existsById(Long id);
}
