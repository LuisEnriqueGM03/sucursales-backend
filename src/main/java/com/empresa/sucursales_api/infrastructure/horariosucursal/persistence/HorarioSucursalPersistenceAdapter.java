package com.empresa.sucursales_api.infrastructure.horariosucursal.persistence;

import com.empresa.sucursales_api.application.horariosucursal.port.out.HorarioSucursalRepositoryPort;
import com.empresa.sucursales_api.domain.horariosucursal.model.HorarioSucursal;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.HorarioSucursalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Adaptador de persistencia para HorarioSucursal
 */
@Component
@RequiredArgsConstructor
public class HorarioSucursalPersistenceAdapter implements HorarioSucursalRepositoryPort {
    
    private final HorarioSucursalJpaRepository jpaRepository;
    private final HorarioSucursalMapper mapper;
    
    @Override
    public HorarioSucursal save(HorarioSucursal horarioSucursal) {
        HorarioSucursalEntity entity = mapper.toEntity(horarioSucursal);
        HorarioSucursalEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }
    
    @Override
    public Optional<HorarioSucursal> findById(HorarioSucursalId id) {
        return jpaRepository.findById(id.getValue())
                .map(mapper::toDomain);
    }
    
    @Override
    public List<HorarioSucursal> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<HorarioSucursal> findBySucursalId(SucursalId sucursalId) {
        return jpaRepository.findBySucursalId(sucursalId.getValue()).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public boolean existsById(HorarioSucursalId id) {
        return jpaRepository.existsById(id.getValue());
    }
    
    @Override
    public void deleteById(HorarioSucursalId id) {
        jpaRepository.deleteById(id.getValue());
    }
}
