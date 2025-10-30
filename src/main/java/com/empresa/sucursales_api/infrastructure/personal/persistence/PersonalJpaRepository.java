package com.empresa.sucursales_api.infrastructure.personal.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonalJpaRepository extends JpaRepository<PersonalEntity, Long> {
    List<PersonalEntity> findByIsActiveTrue();
    List<PersonalEntity> findBySucursalId(Long sucursalId);
    boolean existsByCorreoInstitucional(String correoInstitucional);
    Optional<PersonalEntity> findByCorreoInstitucional(String correoInstitucional);
}
