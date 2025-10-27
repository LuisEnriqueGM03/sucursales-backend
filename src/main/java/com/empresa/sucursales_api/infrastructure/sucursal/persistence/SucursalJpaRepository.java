package com.empresa.sucursales_api.infrastructure.sucursal.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface SucursalJpaRepository extends JpaRepository<SucursalEntity, Long> {
    List<SucursalEntity> findByIsActiveTrue();
}
