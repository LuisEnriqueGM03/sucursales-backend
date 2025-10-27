package com.empresa.sucursales_api.infrastructure.telefonopersonal.persistence;
import com.empresa.sucursales_api.domain.telefonopersonal.model.TelefonoPersonal;
import com.empresa.sucursales_api.domain.telefonopersonal.port.out.TelefonoPersonalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class TelefonoPersonalPersistenceAdapter implements TelefonoPersonalRepositoryPort {
    private final TelefonoPersonalJpaRepository jpaRepository;
    private final TelefonoPersonalMapper mapper;
    @Override
    public TelefonoPersonal save(TelefonoPersonal telefonoPersonal) {
        TelefonoPersonalEntity entity = mapper.toEntity(telefonoPersonal);
        TelefonoPersonalEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }
    @Override
    public Optional<TelefonoPersonal> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
    @Override
    public List<TelefonoPersonal> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    @Override
    public List<TelefonoPersonal> findByPersonalId(Long personalId) {
        return jpaRepository.findByPersonalId(personalId).stream()
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
