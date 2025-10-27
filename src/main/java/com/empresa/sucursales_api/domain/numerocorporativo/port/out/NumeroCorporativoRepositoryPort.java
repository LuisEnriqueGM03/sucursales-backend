package com.empresa.sucursales_api.domain.numerocorporativo.port.out;

import com.empresa.sucursales_api.domain.numerocorporativo.model.NumeroCorporativo;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para operaciones de persistencia de NumeroCorporativo
 */
public interface NumeroCorporativoRepositoryPort {
    
    NumeroCorporativo save(NumeroCorporativo numeroCorporativo);
    
    Optional<NumeroCorporativo> findById(Long id);
    
    List<NumeroCorporativo> findAll();
    
    List<NumeroCorporativo> findBySucursalId(Long sucursalId);
    
    List<NumeroCorporativo> findByPersonalId(Long personalId);
    
    Optional<NumeroCorporativo> findByNumero(String numero);
    
    boolean existsByNumero(String numero);
    
    boolean existsById(Long id);
    
    void deleteById(Long id);
}
