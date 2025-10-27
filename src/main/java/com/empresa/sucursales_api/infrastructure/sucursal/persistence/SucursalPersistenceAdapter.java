package com.empresa.sucursales_api.infrastructure.sucursal.persistence;
import com.empresa.sucursales_api.application.sucursal.port.out.SucursalRepositoryPort;
import com.empresa.sucursales_api.domain.sucursal.model.Sucursal;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class SucursalPersistenceAdapter implements SucursalRepositoryPort {
    private final SucursalJpaRepository jpaRepository;
    private final SucursalMapper mapper;
    @Override
    public Sucursal save(Sucursal sucursal) {
        SucursalEntity entity = mapper.toEntity(sucursal);
        SucursalEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }
    @Override
    public Optional<Sucursal> findById(SucursalId id) {
        return jpaRepository.findById(id.getValue())
                .map(mapper::toDomain);
    }
    @Override
    public List<Sucursal> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    @Override
    public List<Sucursal> findByActiveTrue() {
        return jpaRepository.findByIsActiveTrue().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteById(SucursalId id) {
        jpaRepository.deleteById(id.getValue());
    }
    @Override
    public boolean existsById(SucursalId id) {
        return jpaRepository.existsById(id.getValue());
    }
}
