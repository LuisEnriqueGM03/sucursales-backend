package com.empresa.sucursales_api.application.personal.service;
import com.empresa.sucursales_api.application.personal.dto.PersonalRequest;
import com.empresa.sucursales_api.application.personal.dto.PersonalResponse;
import com.empresa.sucursales_api.application.personal.dto.PersonalUpdateRequest;
import com.empresa.sucursales_api.application.personal.port.in.ManagePersonalUseCase;
import com.empresa.sucursales_api.application.telefonopersonal.dto.TelefonoPersonalResponse;
import com.empresa.sucursales_api.domain.personal.model.Personal;
import com.empresa.sucursales_api.domain.personal.port.out.PersonalRepositoryPort;
import com.empresa.sucursales_api.domain.personal.valueobject.Cargo;
import com.empresa.sucursales_api.domain.personal.valueobject.CorreoInstitucional;
import com.empresa.sucursales_api.domain.personal.valueobject.NombreCompleto;
import com.empresa.sucursales_api.domain.personal.valueobject.Password;
import com.empresa.sucursales_api.domain.personal.valueobject.PersonalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import com.empresa.sucursales_api.domain.telefonopersonal.model.TelefonoPersonal;
import com.empresa.sucursales_api.domain.telefonopersonal.port.out.TelefonoPersonalRepositoryPort;
import com.empresa.sucursales_api.domain.numerocorporativo.model.NumeroCorporativo;
import com.empresa.sucursales_api.domain.numerocorporativo.port.out.NumeroCorporativoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Transactional
public class PersonalService implements ManagePersonalUseCase {
    private final PersonalRepositoryPort repositoryPort;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TelefonoPersonalRepositoryPort telefonoRepositoryPort;
    private final NumeroCorporativoRepositoryPort numeroCorporativoRepositoryPort;
    @Override
    public PersonalResponse createPersonal(PersonalRequest request) {
        if (repositoryPort.existsByCorreoInstitucional(request.getCorreoInstitucional())) {
            throw new RuntimeException("Ya existe un personal con el correo institucional: " + request.getCorreoInstitucional());
        }
        // Hashear el password con bcrypt
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        
        Personal personal = Personal.builder()
                .nombreCompleto(NombreCompleto.of(request.getNombreCompleto()))
                .cargo(Cargo.of(request.getCargo()))
                .correoInstitucional(CorreoInstitucional.of(request.getCorreoInstitucional()))
                .password(Password.of(hashedPassword))
                .sucursalId(request.getSucursalId() != null ? SucursalId.of(request.getSucursalId()) : null)
                .active(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        Personal savedPersonal = repositoryPort.save(personal);
        return mapToResponse(savedPersonal);
    }
    @Override
    @Transactional(readOnly = true)
    public PersonalResponse getPersonalById(Long id) {
        PersonalId personalId = PersonalId.of(id);
        Personal personal = repositoryPort.findById(personalId)
                .orElseThrow(() -> new RuntimeException("Personal no encontrado con id: " + id));
        return mapToResponse(personal);
    }
    @Override
    @Transactional(readOnly = true)
    public List<PersonalResponse> getAllPersonal() {
        return repositoryPort.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public List<PersonalResponse> getActivePersonal() {
        return repositoryPort.findByActiveTrue().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public List<PersonalResponse> getPersonalBySucursalId(Long sucursalId) {
        return repositoryPort.findBySucursalId(sucursalId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    public PersonalResponse updatePersonal(Long id, PersonalUpdateRequest request) {
        PersonalId personalId = PersonalId.of(id);
        Personal existingPersonal = repositoryPort.findById(personalId)
                .orElseThrow(() -> new RuntimeException("Personal no encontrado con id: " + id));
        Personal updatedPersonal = existingPersonal
                .withNombreCompleto(request.getNombreCompleto() != null ? 
                        NombreCompleto.of(request.getNombreCompleto()) : existingPersonal.getNombreCompleto())
                .withCargo(request.getCargo() != null ? 
                        Cargo.of(request.getCargo()) : existingPersonal.getCargo())
                .withCorreoInstitucional(request.getCorreoInstitucional() != null ? 
                        CorreoInstitucional.of(request.getCorreoInstitucional()) : existingPersonal.getCorreoInstitucional())
                .withPassword(request.getPassword() != null && !request.getPassword().trim().isEmpty() ? 
                        Password.of(passwordEncoder.encode(request.getPassword())) : existingPersonal.getPassword())
                .withSucursalId(request.getSucursalId() != null ? 
                        SucursalId.of(request.getSucursalId()) : existingPersonal.getSucursalId())
                .withActive(request.getActive() != null ? request.getActive() : existingPersonal.isActive())
                .withUpdatedAt(LocalDateTime.now());
        Personal savedPersonal = repositoryPort.save(updatedPersonal);
        return mapToResponse(savedPersonal);
    }
    @Override
    public void deletePersonal(Long id) {
        PersonalId personalId = PersonalId.of(id);
        if (!repositoryPort.existsById(personalId)) {
            throw new RuntimeException("Personal no encontrado con id: " + id);
        }
        
        // 1. Eliminar todos los teléfonos personales asociados
        List<TelefonoPersonal> telefonos = telefonoRepositoryPort.findByPersonalId(id);
        for (TelefonoPersonal telefono : telefonos) {
            if (telefono.getId() != null) {
                telefonoRepositoryPort.deleteById(telefono.getId().getValue());
            }
        }
        
        // 2. Poner en null el personalId de los números corporativos asociados
        List<NumeroCorporativo> numeros = numeroCorporativoRepositoryPort.findByPersonalId(id);
        for (NumeroCorporativo numero : numeros) {
            NumeroCorporativo updatedNumero = numero.withPersonalId(null);
            numeroCorporativoRepositoryPort.save(updatedNumero);
        }
        
        // 3. Finalmente eliminar el personal
        repositoryPort.deleteById(personalId);
    }
    @Override
    public void deactivatePersonal(Long id) {
        PersonalId personalId = PersonalId.of(id);
        Personal personal = repositoryPort.findById(personalId)
                .orElseThrow(() -> new RuntimeException("Personal no encontrado con id: " + id));
        Personal deactivatedPersonal = personal
                .withActive(false)
                .withUpdatedAt(LocalDateTime.now());
        repositoryPort.save(deactivatedPersonal);
    }
    private PersonalResponse mapToResponse(Personal personal) {
        List<TelefonoPersonalResponse> telefonos = null;
        if (personal.getId() != null) {
            List<TelefonoPersonal> telefonoPersonales = telefonoRepositoryPort.findByPersonalId(personal.getId().getValue());
            telefonos = telefonoPersonales.stream()
                    .map(this::mapTelefonoToResponse)
                    .collect(Collectors.toList());
        }
        return PersonalResponse.builder()
                .id(personal.getId() != null ? personal.getId().getValue() : null)
                .nombreCompleto(personal.getNombreCompleto() != null ? personal.getNombreCompleto().getValue() : null)
                .cargo(personal.getCargo() != null && personal.getCargo().getValue() != null ? 
                        personal.getCargo().getValue().getDisplayName() : null)
                .correoInstitucional(personal.getCorreoInstitucional() != null ? personal.getCorreoInstitucional().getValue() : null)
                .sucursalId(personal.getSucursalId() != null ? personal.getSucursalId().getValue() : null)
                .telefonos(telefonos)
                .active(personal.isActive())
                .createdAt(personal.getCreatedAt())
                .updatedAt(personal.getUpdatedAt())
                .build();
    }
    private TelefonoPersonalResponse mapTelefonoToResponse(TelefonoPersonal telefono) {
        return TelefonoPersonalResponse.builder()
                .id(telefono.getId() != null ? telefono.getId().getValue() : null)
                .personalId(telefono.getPersonalId() != null ? telefono.getPersonalId().getValue() : null)
                .numero(telefono.getNumero() != null ? telefono.getNumero().getValue() : null)
                .tipo(telefono.getTipo() != null ? telefono.getTipo().getValue() : null)
                .build();
    }
}
