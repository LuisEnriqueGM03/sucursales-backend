package com.empresa.sucursales_api.infrastructure.imagensucursal.persistence;

import com.empresa.sucursales_api.domain.imagensucursal.model.ImagenSucursal;
import com.empresa.sucursales_api.domain.imagensucursal.port.out.ImagenSucursalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Adaptador de persistencia para ImagenSucursal
 */
@Component
@RequiredArgsConstructor
public class ImagenSucursalPersistenceAdapter implements ImagenSucursalRepositoryPort {
    
    private final ImagenSucursalJpaRepository jpaRepository;
    private final ImagenSucursalMapper mapper;
    
    @Override
    public ImagenSucursal save(ImagenSucursal imagenSucursal) {
        ImagenSucursalEntity entity = mapper.toEntity(imagenSucursal);
        ImagenSucursalEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }
    
    @Override
    public Optional<ImagenSucursal> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
    
    @Override
    public List<ImagenSucursal> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<ImagenSucursal> findBySucursalId(Long sucursalId) {
        return jpaRepository.findBySucursalId(sucursalId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
