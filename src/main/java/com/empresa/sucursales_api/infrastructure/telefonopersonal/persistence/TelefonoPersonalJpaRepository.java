package com.empresa.sucursales_api.infrastructure.telefonopersonal.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TelefonoPersonalJpaRepository extends JpaRepository<TelefonoPersonalEntity, Long> {
    List<TelefonoPersonalEntity> findByPersonalId(Long personalId);
}
