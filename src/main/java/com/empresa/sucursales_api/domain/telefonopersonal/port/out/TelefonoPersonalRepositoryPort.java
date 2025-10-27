package com.empresa.sucursales_api.domain.telefonopersonal.port.out;
import com.empresa.sucursales_api.domain.telefonopersonal.model.TelefonoPersonal;
import java.util.List;
import java.util.Optional;
public interface TelefonoPersonalRepositoryPort {
    TelefonoPersonal save(TelefonoPersonal telefonoPersonal);
    Optional<TelefonoPersonal> findById(Long id);
    List<TelefonoPersonal> findAll();
    List<TelefonoPersonal> findByPersonalId(Long personalId);
    boolean existsById(Long id);
    void deleteById(Long id);
}
