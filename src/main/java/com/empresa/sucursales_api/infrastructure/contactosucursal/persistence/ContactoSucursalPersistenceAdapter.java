package com.empresa.sucursales_api.infrastructure.contactosucursal.persistence;
import com.empresa.sucursales_api.domain.contactosucursal.model.ContactoSucursal;
import com.empresa.sucursales_api.domain.contactosucursal.port.out.ContactoSucursalRepositoryPort;
import com.empresa.sucursales_api.infrastructure.contactosucursal.persistence.ContactoSucursalEntity;
import com.empresa.sucursales_api.infrastructure.contactosucursal.persistence.ContactoSucursalJpaRepository;
import com.empresa.sucursales_api.infrastructure.contactosucursal.persistence.ContactoSucursalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class ContactoSucursalPersistenceAdapter implements ContactoSucursalRepositoryPort {
    private final ContactoSucursalJpaRepository jpaRepository;
    private final ContactoSucursalMapper mapper;
    @Override
    public ContactoSucursal save(ContactoSucursal contacto) {
        ContactoSucursalEntity entity = mapper.toEntity(contacto);
        ContactoSucursalEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }
    @Override
    public Optional<ContactoSucursal> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
    @Override
    public List<ContactoSucursal> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    @Override
    public List<ContactoSucursal> findBySucursalId(Long sucursalId) {
        return jpaRepository.findBySucursalId(sucursalId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}