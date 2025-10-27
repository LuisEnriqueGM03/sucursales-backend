package com.empresa.sucursales_api.infrastructure.horariosucursal.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface HorarioSucursalJpaRepository extends JpaRepository<HorarioSucursalEntity, Long> {
    List<HorarioSucursalEntity> findBySucursalId(Long sucursalId);
}
