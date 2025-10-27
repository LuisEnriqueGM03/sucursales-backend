package com.empresa.sucursales_api.infrastructure.numerocorporativo.persistence;
import com.empresa.sucursales_api.domain.numerocorporativo.model.NumeroCorporativo;
import com.empresa.sucursales_api.domain.numerocorporativo.port.out.NumeroCorporativoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class NumeroCorporativoPersistenceAdapter implements NumeroCorporativoRepositoryPort {
    private final NumeroCorporativoJpaRepository jpaRepository;
    private final NumeroCorporativoMapper mapper;
    @Override
    public NumeroCorporativo save(NumeroCorporativo numeroCorporativo) {
        NumeroCorporativoEntity entity = mapper.toEntity(numeroCorporativo);
        NumeroCorporativoEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }
    @Override
    public Optional<NumeroCorporativo> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
    @Override
    public List<NumeroCorporativo> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    @Override
    public List<NumeroCorporativo> findBySucursalId(Long sucursalId) {
        return jpaRepository.findBySucursalId(sucursalId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    @Override
    public List<NumeroCorporativo> findByPersonalId(Long personalId) {
        return jpaRepository.findByPersonalId(personalId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
    @Override
    public Optional<NumeroCorporativo> findByNumero(String numero) {
        return jpaRepository.findByNumero(numero)
                .map(mapper::toDomain);
    }
    @Override
    public boolean existsByNumero(String numero) {
        return jpaRepository.existsByNumero(numero);
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
