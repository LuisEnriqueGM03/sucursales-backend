package com.empresa.sucursales_api.infrastructure.imagensucursal.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ImagenSucursalJpaRepository extends JpaRepository<ImagenSucursalEntity, Long> {
    List<ImagenSucursalEntity> findBySucursalId(Long sucursalId);
}
