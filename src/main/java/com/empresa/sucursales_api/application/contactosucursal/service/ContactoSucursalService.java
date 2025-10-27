package com.empresa.sucursales_api.application.contactosucursal.service;

import com.empresa.sucursales_api.application.contactosucursal.dto.ContactoSucursalRequest;
import com.empresa.sucursales_api.application.contactosucursal.dto.ContactoSucursalResponse;
import com.empresa.sucursales_api.application.contactosucursal.dto.ContactoSucursalUpdateRequest;
import com.empresa.sucursales_api.application.contactosucursal.port.in.ManageContactoSucursalUseCase;
import com.empresa.sucursales_api.domain.contactosucursal.model.ContactoSucursal;
import com.empresa.sucursales_api.domain.contactosucursal.port.out.ContactoSucursalRepositoryPort;
import com.empresa.sucursales_api.domain.contactosucursal.valueobject.NumeroContacto;
import com.empresa.sucursales_api.domain.contactosucursal.valueobject.TipoContacto;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio de aplicación que implementa los casos de uso de ContactoSucursal
 */
@RequiredArgsConstructor
public class ContactoSucursalService implements ManageContactoSucursalUseCase {

    private final ContactoSucursalRepositoryPort contactoRepository;

    @Override
    public ContactoSucursalResponse createContacto(ContactoSucursalRequest request) {
        ContactoSucursal contacto = ContactoSucursal.builder()
                .sucursalId(SucursalId.of(request.sucursalId()))
                .numero(NumeroContacto.of(request.numero()))
                .tipo(TipoContacto.of(request.tipo()))
                .build();

        ContactoSucursal savedContacto = contactoRepository.save(contacto);
        return mapToResponse(savedContacto);
    }

    @Override
    public ContactoSucursalResponse getContactoById(Long id) {
        return contactoRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Contacto no encontrado con id: " + id));
    }

    @Override
    public List<ContactoSucursalResponse> getAllContactos() {
        return contactoRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactoSucursalResponse> getContactosBySucursalId(Long sucursalId) {
        return contactoRepository.findBySucursalId(sucursalId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ContactoSucursalResponse updateContacto(Long id, ContactoSucursalUpdateRequest request) {
        ContactoSucursal existingContacto = contactoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contacto no encontrado con id: " + id));

        ContactoSucursal updatedContacto = existingContacto
                .withNumero(NumeroContacto.of(request.numero()));

        if (request.tipo() != null && !request.tipo().trim().isEmpty()) {
            updatedContacto = updatedContacto.withTipo(TipoContacto.of(request.tipo()));
        }

        ContactoSucursal savedContacto = contactoRepository.save(updatedContacto);
        return mapToResponse(savedContacto);
    }

    @Override
    public void deleteContacto(Long id) {
        if (!contactoRepository.existsById(id)) {
            throw new RuntimeException("Contacto no encontrado con id: " + id);
        }
        contactoRepository.deleteById(id);
    }

    private ContactoSucursalResponse mapToResponse(ContactoSucursal contacto) {
        return ContactoSucursalResponse.builder()
                .id(contacto.getId() != null ? contacto.getId().getValue() : null)
                .sucursalId(contacto.getSucursalId() != null ? contacto.getSucursalId().getValue() : null)
                .numero(contacto.getNumero() != null ? contacto.getNumero().getValue() : null)
                .tipo(contacto.getTipo() != null ? contacto.getTipo().getValue() : null)
                .build();
    }
}
