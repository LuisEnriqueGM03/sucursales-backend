package com.empresa.sucursales_api.infrastructure.contactosucursal.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio Spring Data JPA para ContactoSucursalEntity
 */
@Repository
public interface ContactoSucursalJpaRepository extends JpaRepository<ContactoSucursalEntity, Long> {
    List<ContactoSucursalEntity> findBySucursalId(Long sucursalId);
}
