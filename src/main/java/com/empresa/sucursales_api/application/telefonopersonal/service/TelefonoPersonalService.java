package com.empresa.sucursales_api.application.telefonopersonal.service;

import com.empresa.sucursales_api.application.telefonopersonal.dto.TelefonoPersonalRequest;
import com.empresa.sucursales_api.application.telefonopersonal.dto.TelefonoPersonalResponse;
import com.empresa.sucursales_api.application.telefonopersonal.dto.TelefonoPersonalUpdateRequest;
import com.empresa.sucursales_api.application.telefonopersonal.port.in.ManageTelefonoPersonalUseCase;
import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import com.empresa.sucursales_api.domain.telefonopersonal.model.TelefonoPersonal;
import com.empresa.sucursales_api.domain.telefonopersonal.port.out.TelefonoPersonalRepositoryPort;
import com.empresa.sucursales_api.domain.telefonopersonal.valueobject.NumeroTelefono;
import com.empresa.sucursales_api.domain.telefonopersonal.valueobject.TipoTelefono;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio de aplicación que implementa los casos de uso de TelefonoPersonal
 */
@RequiredArgsConstructor
public class TelefonoPersonalService implements ManageTelefonoPersonalUseCase {

    private final TelefonoPersonalRepositoryPort telefonoRepository;

    @Override
    public TelefonoPersonalResponse createTelefono(TelefonoPersonalRequest request) {
        TelefonoPersonal telefono = TelefonoPersonal.builder()
                .personalId(PersonalId.of(request.personalId()))
                .numero(NumeroTelefono.of(request.numero()))
                .tipo(TipoTelefono.of(request.tipo()))
                .build();

        TelefonoPersonal savedTelefono = telefonoRepository.save(telefono);
        return mapToResponse(savedTelefono);
    }

    @Override
    public TelefonoPersonalResponse getTelefonoById(Long id) {
        return telefonoRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con id: " + id));
    }

    @Override
    public List<TelefonoPersonalResponse> getAllTelefonos() {
        return telefonoRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<TelefonoPersonalResponse> getTelefonosByPersonalId(Long personalId) {
        return telefonoRepository.findByPersonalId(personalId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TelefonoPersonalResponse updateTelefono(Long id, TelefonoPersonalUpdateRequest request) {
        TelefonoPersonal existingTelefono = telefonoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con id: " + id));

        TelefonoPersonal updatedTelefono = existingTelefono
                .withNumero(NumeroTelefono.of(request.numero()));

        if (request.tipo() != null && !request.tipo().trim().isEmpty()) {
            updatedTelefono = updatedTelefono.withTipo(TipoTelefono.of(request.tipo()));
        }

        TelefonoPersonal savedTelefono = telefonoRepository.save(updatedTelefono);
        return mapToResponse(savedTelefono);
    }

    @Override
    public void deleteTelefono(Long id) {
        if (!telefonoRepository.existsById(id)) {
            throw new RuntimeException("Teléfono no encontrado con id: " + id);
        }
        telefonoRepository.deleteById(id);
    }

    private TelefonoPersonalResponse mapToResponse(TelefonoPersonal telefono) {
        return TelefonoPersonalResponse.builder()
                .id(telefono.getId() != null ? telefono.getId().getValue() : null)
                .personalId(telefono.getPersonalId() != null ? telefono.getPersonalId().getValue() : null)
                .numero(telefono.getNumero() != null ? telefono.getNumero().getValue() : null)
                .tipo(telefono.getTipo() != null ? telefono.getTipo().getValue() : null)
                .build();
    }
}
