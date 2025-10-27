package com.empresa.sucursales_api.infrastructure.personal.persistence;

import com.empresa.sucursales_api.domain.personal.model.Personal;
import com.empresa.sucursales_api.domain.personal.port.out.PersonalRepositoryPort;
import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Adaptador de persistencia que implementa el puerto PersonalRepositoryPort
 */
@Component
@RequiredArgsConstructor
public class PersonalPersistenceAdapter implements PersonalRepositoryPort {
    
    private final PersonalJpaRepository jpaRepository;
    private final PersonalMapper mapper;
    
    @Override
    public Personal save(Personal personal) {
        PersonalEntity entity = mapper.toEntity(personal);
        PersonalEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }
    
    @Override
    public Optional<Personal> findById(PersonalId id) {
        return jpaRepository.findById(id.getValue())
                .map(mapper::toDomain);
    }
    
    @Override
    public List<Personal> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Personal> findByActiveTrue() {
        return jpaRepository.findByIsActiveTrue().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Personal> findBySucursalId(Long sucursalId) {
        return jpaRepository.findBySucursalId(sucursalId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public void deleteById(PersonalId id) {
        jpaRepository.deleteById(id.getValue());
    }
    
    @Override
    public boolean existsById(PersonalId id) {
        return jpaRepository.existsById(id.getValue());
    }
    
    @Override
    public boolean existsByCorreoInstitucional(String correo) {
        return jpaRepository.existsByCorreoInstitucional(correo);
    }
}
