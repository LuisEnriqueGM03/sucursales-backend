package com.empresa.sucursales_api.application.numerocorporativo.service;

import com.empresa.sucursales_api.application.numerocorporativo.dto.NumeroCorporativoRequest;
import com.empresa.sucursales_api.application.numerocorporativo.dto.NumeroCorporativoResponse;
import com.empresa.sucursales_api.application.numerocorporativo.dto.NumeroCorporativoUpdateRequest;
import com.empresa.sucursales_api.application.numerocorporativo.port.in.ManageNumeroCorporativoUseCase;
import com.empresa.sucursales_api.domain.numerocorporativo.model.NumeroCorporativo;
import com.empresa.sucursales_api.domain.numerocorporativo.port.out.NumeroCorporativoRepositoryPort;
import com.empresa.sucursales_api.domain.numerocorporativo.valueobject.Numero;
import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio de aplicación que implementa los casos de uso de NumeroCorporativo
 */
@RequiredArgsConstructor
public class NumeroCorporativoService implements ManageNumeroCorporativoUseCase {

    private final NumeroCorporativoRepositoryPort numeroRepository;

    @Override
    public NumeroCorporativoResponse createNumero(NumeroCorporativoRequest request) {
        // Validar que el número no exista
        if (numeroRepository.existsByNumero(request.numero())) {
            throw new RuntimeException("El número corporativo ya existe: " + request.numero());
        }

        NumeroCorporativo numero = NumeroCorporativo.builder()
                .numero(Numero.of(request.numero()))
                .sucursalId(SucursalId.of(request.sucursalId()))
                .personalId(request.personalId() != null ? PersonalId.of(request.personalId()) : null)
                .build();

        NumeroCorporativo savedNumero = numeroRepository.save(numero);
        return mapToResponse(savedNumero);
    }

    @Override
    public NumeroCorporativoResponse getNumeroById(Long id) {
        return numeroRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Número corporativo no encontrado con id: " + id));
    }

    @Override
    public NumeroCorporativoResponse getNumeroByNumero(String numero) {
        return numeroRepository.findByNumero(numero)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Número corporativo no encontrado: " + numero));
    }

    @Override
    public List<NumeroCorporativoResponse> getAllNumeros() {
        return numeroRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<NumeroCorporativoResponse> getNumerosBySucursalId(Long sucursalId) {
        return numeroRepository.findBySucursalId(sucursalId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<NumeroCorporativoResponse> getNumerosByPersonalId(Long personalId) {
        return numeroRepository.findByPersonalId(personalId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public NumeroCorporativoResponse updateNumero(Long id, NumeroCorporativoUpdateRequest request) {
        NumeroCorporativo existingNumero = numeroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Número corporativo no encontrado con id: " + id));

        NumeroCorporativo updatedNumero = existingNumero;

        // Actualizar número si se proporciona
        if (request.numero() != null && !request.numero().trim().isEmpty()) {
            // Validar que el nuevo número no exista (excepto si es el mismo)
            if (!request.numero().equals(existingNumero.getNumero().getValue()) 
                    && numeroRepository.existsByNumero(request.numero())) {
                throw new RuntimeException("El número corporativo ya existe: " + request.numero());
            }
            updatedNumero = updatedNumero.withNumero(Numero.of(request.numero()));
        }

        // Actualizar sucursal si se proporciona
        if (request.sucursalId() != null) {
            updatedNumero = updatedNumero.withSucursalId(SucursalId.of(request.sucursalId()));
        }

        // Actualizar personal si se proporciona (null es válido para desasignar)
        if (request.personalId() != null) {
            updatedNumero = updatedNumero.withPersonalId(PersonalId.of(request.personalId()));
        }

        NumeroCorporativo savedNumero = numeroRepository.save(updatedNumero);
        return mapToResponse(savedNumero);
    }

    @Override
    public NumeroCorporativoResponse assignToPersonal(Long id, Long personalId) {
        NumeroCorporativo existingNumero = numeroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Número corporativo no encontrado con id: " + id));

        NumeroCorporativo updatedNumero = existingNumero.withPersonalId(PersonalId.of(personalId));
        NumeroCorporativo savedNumero = numeroRepository.save(updatedNumero);
        return mapToResponse(savedNumero);
    }

    @Override
    public NumeroCorporativoResponse unassignFromPersonal(Long id) {
        NumeroCorporativo existingNumero = numeroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Número corporativo no encontrado con id: " + id));

        NumeroCorporativo updatedNumero = existingNumero.withPersonalId(null);
        NumeroCorporativo savedNumero = numeroRepository.save(updatedNumero);
        return mapToResponse(savedNumero);
    }

    @Override
    public void deleteNumero(Long id) {
        if (!numeroRepository.existsById(id)) {
            throw new RuntimeException("Número corporativo no encontrado con id: " + id);
        }
        numeroRepository.deleteById(id);
    }

    private NumeroCorporativoResponse mapToResponse(NumeroCorporativo numero) {
        return NumeroCorporativoResponse.builder()
                .id(numero.getId() != null ? numero.getId().getValue() : null)
                .numero(numero.getNumero() != null ? numero.getNumero().getValue() : null)
                .sucursalId(numero.getSucursalId() != null ? numero.getSucursalId().getValue() : null)
                .personalId(numero.getPersonalId() != null ? numero.getPersonalId().getValue() : null)
                .build();
    }
}
