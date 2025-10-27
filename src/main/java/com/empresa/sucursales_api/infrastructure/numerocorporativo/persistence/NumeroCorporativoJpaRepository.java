package com.empresa.sucursales_api.infrastructure.numerocorporativo.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface NumeroCorporativoJpaRepository extends JpaRepository<NumeroCorporativoEntity, Long> {
    List<NumeroCorporativoEntity> findBySucursalId(Long sucursalId);
    List<NumeroCorporativoEntity> findByPersonalId(Long personalId);
    Optional<NumeroCorporativoEntity> findByNumero(String numero);
    boolean existsByNumero(String numero);
}
