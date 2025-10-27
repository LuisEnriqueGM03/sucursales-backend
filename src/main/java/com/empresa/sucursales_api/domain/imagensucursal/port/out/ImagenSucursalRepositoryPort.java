package com.empresa.sucursales_api.domain.imagensucursal.port.out;

import com.empresa.sucursales_api.domain.imagensucursal.model.ImagenSucursal;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para operaciones de persistencia de ImagenSucursal
 */
public interface ImagenSucursalRepositoryPort {
    
    ImagenSucursal save(ImagenSucursal imagenSucursal);
    
    Optional<ImagenSucursal> findById(Long id);
    
    List<ImagenSucursal> findAll();
    
    List<ImagenSucursal> findBySucursalId(Long sucursalId);
    
    boolean existsById(Long id);
    
    void deleteById(Long id);
}
