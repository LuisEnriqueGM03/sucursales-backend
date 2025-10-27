package com.empresa.sucursales_api.domain.personal.port.out;
import com.empresa.sucursales_api.domain.personal.model.Personal;
import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import java.util.List;
import java.util.Optional;
public interface PersonalRepositoryPort {
    Personal save(Personal personal);
    Optional<Personal> findById(PersonalId id);
    List<Personal> findAll();
    List<Personal> findByActiveTrue();
    List<Personal> findBySucursalId(Long sucursalId);
    void deleteById(PersonalId id);
    boolean existsById(PersonalId id);
    boolean existsByCorreoInstitucional(String correo);
}
