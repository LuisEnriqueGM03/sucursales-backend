package com.empresa.sucursales_api.application.sucursal.service;
import com.empresa.sucursales_api.application.contactosucursal.dto.ContactoSucursalResponse;
import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalResponse;
import com.empresa.sucursales_api.application.imagensucursal.dto.ImagenSucursalResponse;
import com.empresa.sucursales_api.application.horariosucursal.port.out.HorarioSucursalRepositoryPort;
import com.empresa.sucursales_api.application.sucursal.dto.SucursalRequest;
import com.empresa.sucursales_api.application.sucursal.dto.SucursalResponse;
import com.empresa.sucursales_api.application.sucursal.dto.SucursalUpdateRequest;
import com.empresa.sucursales_api.application.sucursal.port.in.CreateSucursalUseCase;
import com.empresa.sucursales_api.application.sucursal.port.in.DeleteSucursalUseCase;
import com.empresa.sucursales_api.application.sucursal.port.in.GetSucursalUseCase;
import com.empresa.sucursales_api.application.sucursal.port.in.UpdateSucursalUseCase;
import com.empresa.sucursales_api.application.sucursal.port.out.SucursalRepositoryPort;
import com.empresa.sucursales_api.domain.contactosucursal.model.ContactoSucursal;
import com.empresa.sucursales_api.domain.contactosucursal.port.out.ContactoSucursalRepositoryPort;
import com.empresa.sucursales_api.domain.horariosucursal.model.HorarioSucursal;
import com.empresa.sucursales_api.domain.imagensucursal.model.ImagenSucursal;
import com.empresa.sucursales_api.domain.imagensucursal.port.out.ImagenSucursalRepositoryPort;
import com.empresa.sucursales_api.domain.numerocorporativo.model.NumeroCorporativo;
import com.empresa.sucursales_api.domain.numerocorporativo.port.out.NumeroCorporativoRepositoryPort;
import com.empresa.sucursales_api.domain.personal.model.Personal;
import com.empresa.sucursales_api.domain.personal.port.out.PersonalRepositoryPort;
import com.empresa.sucursales_api.domain.sucursal.model.Sucursal;
import com.empresa.sucursales_api.domain.sucursal.valueobject.Coordenadas;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.Direccion;
import com.empresa.sucursales_api.domain.sucursal.valueobject.TelefonoPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Transactional
public class SucursalService implements CreateSucursalUseCase, GetSucursalUseCase, 
                                        UpdateSucursalUseCase, DeleteSucursalUseCase {
    private final SucursalRepositoryPort repositoryPort;
    private final HorarioSucursalRepositoryPort horarioRepositoryPort;
    private final ContactoSucursalRepositoryPort contactoRepositoryPort;
    private final ImagenSucursalRepositoryPort imagenRepositoryPort;
    private final PersonalRepositoryPort personalRepositoryPort;
    private final NumeroCorporativoRepositoryPort numeroCorporativoRepositoryPort;
    @Override
    public SucursalResponse createSucursal(SucursalRequest request) {
        Coordenadas coordenadas = null;
        if (request.getLatitud() != null && request.getLongitud() != null) {
            coordenadas = Coordenadas.of(request.getLatitud(), request.getLongitud());
        }
        Sucursal sucursal = Sucursal.builder()
                .nombre(request.getNombre())
                .direccion(Direccion.of(request.getDireccion()))
                .telefonoPrincipal(request.getTelefonoPrincipal() != null ? 
                        TelefonoPrincipal.of(request.getTelefonoPrincipal()) : null)
                .coordenadas(coordenadas)
                .active(request.getActive() != null ? request.getActive() : true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        Sucursal savedSucursal = repositoryPort.save(sucursal);
        return mapToResponse(savedSucursal);
    }
    @Override
    @Transactional(readOnly = true)
    public SucursalResponse getSucursalById(Long id) {
        SucursalId sucursalId = SucursalId.of(id);
        Sucursal sucursal = repositoryPort.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con id: " + id));
        return mapToResponse(sucursal);
    }
    @Override
    @Transactional(readOnly = true)
    public List<SucursalResponse> getAllSucursales() {
        return repositoryPort.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public List<SucursalResponse> getActiveSucursales() {
        return repositoryPort.findByActiveTrue().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    public SucursalResponse updateSucursal(Long id, SucursalUpdateRequest request) {
        SucursalId sucursalId = SucursalId.of(id);
        Sucursal existingSucursal = repositoryPort.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con id: " + id));
        Coordenadas coordenadas = existingSucursal.getCoordenadas();
        if (request.getLatitud() != null || request.getLongitud() != null) {
            coordenadas = Coordenadas.of(
                    request.getLatitud() != null ? request.getLatitud() : 
                            (coordenadas != null ? coordenadas.getLatitud() : null),
                    request.getLongitud() != null ? request.getLongitud() : 
                            (coordenadas != null ? coordenadas.getLongitud() : null)
            );
        }
        Sucursal updatedSucursal = existingSucursal
                .withNombre(request.getNombre() != null ? request.getNombre() : existingSucursal.getNombre())
                .withDireccion(request.getDireccion() != null ? Direccion.of(request.getDireccion()) : existingSucursal.getDireccion())
                .withTelefonoPrincipal(request.getTelefonoPrincipal() != null ? 
                        TelefonoPrincipal.of(request.getTelefonoPrincipal()) : existingSucursal.getTelefonoPrincipal())
                .withCoordenadas(coordenadas)
                .withActive(request.getActive() != null ? request.getActive() : existingSucursal.isActive())
                .withUpdatedAt(LocalDateTime.now());
        Sucursal savedSucursal = repositoryPort.save(updatedSucursal);
        return mapToResponse(savedSucursal);
    }
    @Override
    public void deleteSucursal(Long id) {
        SucursalId sucursalId = SucursalId.of(id);
        if (!repositoryPort.existsById(sucursalId)) {
            throw new RuntimeException("Sucursal no encontrada con id: " + id);
        }
        
        // 1. Actualizar personal: poner sucursalId en null
        List<Personal> personalList = personalRepositoryPort.findBySucursalId(id);
        for (Personal personal : personalList) {
            Personal updatedPersonal = personal.withSucursalId(null);
            personalRepositoryPort.save(updatedPersonal);
        }
        
        // 2. Eliminar todos los horarios de la sucursal
        List<HorarioSucursal> horarios = horarioRepositoryPort.findBySucursalId(sucursalId);
        for (HorarioSucursal horario : horarios) {
            if (horario.getId() != null) {
                horarioRepositoryPort.deleteById(horario.getId());
            }
        }
        
        // 3. Eliminar todos los números corporativos de la sucursal
        List<NumeroCorporativo> numeros = numeroCorporativoRepositoryPort.findBySucursalId(id);
        for (NumeroCorporativo numero : numeros) {
            if (numero.getId() != null) {
                numeroCorporativoRepositoryPort.deleteById(numero.getId().getValue());
            }
        }
        
        // 4. Eliminar todas las imágenes de la sucursal
        List<ImagenSucursal> imagenes = imagenRepositoryPort.findBySucursalId(id);
        for (ImagenSucursal imagen : imagenes) {
            if (imagen.getId() != null) {
                imagenRepositoryPort.deleteById(imagen.getId().getValue());
            }
        }
        
        // 5. Eliminar contactos de la sucursal
        List<ContactoSucursal> contactos = contactoRepositoryPort.findBySucursalId(id);
        for (ContactoSucursal contacto : contactos) {
            if (contacto.getId() != null) {
                contactoRepositoryPort.deleteById(contacto.getId().getValue());
            }
        }
        
        // 6. Finalmente eliminar la sucursal
        repositoryPort.deleteById(sucursalId);
    }
    @Override
    public void deactivateSucursal(Long id) {
        SucursalId sucursalId = SucursalId.of(id);
        Sucursal sucursal = repositoryPort.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con id: " + id));
        Sucursal deactivatedSucursal = sucursal
                .withActive(false)
                .withUpdatedAt(LocalDateTime.now());
        repositoryPort.save(deactivatedSucursal);
    }
    private SucursalResponse mapToResponse(Sucursal sucursal) {
        List<HorarioSucursalResponse> horarios = null;
        if (sucursal.getId() != null) {
            List<HorarioSucursal> horarioSucursales = horarioRepositoryPort.findBySucursalId(sucursal.getId());
            horarios = horarioSucursales.stream()
                    .map(this::mapHorarioToResponse)
                    .collect(Collectors.toList());
        }
        List<ContactoSucursalResponse> contactos = null;
        if (sucursal.getId() != null) {
            List<ContactoSucursal> contactoSucursales = contactoRepositoryPort.findBySucursalId(sucursal.getId().getValue());
            contactos = contactoSucursales.stream()
                    .map(this::mapContactoToResponse)
                    .collect(Collectors.toList());
        }
        List<ImagenSucursalResponse> imagenes = null;
        if (sucursal.getId() != null) {
            List<ImagenSucursal> imagenSucursales = imagenRepositoryPort.findBySucursalId(sucursal.getId().getValue());
            imagenes = imagenSucursales.stream()
                    .map(this::mapImagenToResponse)
                    .collect(Collectors.toList());
        }
        return SucursalResponse.builder()
                .id(sucursal.getId() != null ? sucursal.getId().getValue() : null)
                .nombre(sucursal.getNombre())
                .direccion(sucursal.getDireccion() != null ? sucursal.getDireccion().getValue() : null)
                .telefonoPrincipal(sucursal.getTelefonoPrincipal() != null ? sucursal.getTelefonoPrincipal().getValue() : null)
                .latitud(sucursal.getCoordenadas() != null ? sucursal.getCoordenadas().getLatitud() : null)
                .longitud(sucursal.getCoordenadas() != null ? sucursal.getCoordenadas().getLongitud() : null)
                .horarios(horarios)
                .contactos(contactos)
                .imagenes(imagenes)
                .active(sucursal.isActive())
                .createdAt(sucursal.getCreatedAt())
                .updatedAt(sucursal.getUpdatedAt())
                .build();
    }
    private HorarioSucursalResponse mapHorarioToResponse(HorarioSucursal horario) {
        return HorarioSucursalResponse.builder()
                .id(horario.getId() != null ? horario.getId().getValue() : null)
                .sucursalId(horario.getSucursalId() != null ? horario.getSucursalId().getValue() : null)
                .diaSemana(horario.getDiaSemana() != null ? horario.getDiaSemana().getNombre() : null)
                .horaApertura(horario.getHoraApertura() != null ? horario.getHoraApertura().getValue() : null)
                .horaCierre(horario.getHoraCierre() != null ? horario.getHoraCierre().getValue() : null)
                .build();
    }
    private ContactoSucursalResponse mapContactoToResponse(ContactoSucursal contacto) {
        return ContactoSucursalResponse.builder()
                .id(contacto.getId() != null ? contacto.getId().getValue() : null)
                .sucursalId(contacto.getSucursalId() != null ? contacto.getSucursalId().getValue() : null)
                .numero(contacto.getNumero() != null ? contacto.getNumero().getValue() : null)
                .tipo(contacto.getTipo() != null ? contacto.getTipo().getValue() : null)
                .build();
    }
    private ImagenSucursalResponse mapImagenToResponse(ImagenSucursal imagen) {
        return ImagenSucursalResponse.builder()
                .id(imagen.getId() != null ? imagen.getId().getValue() : null)
                .sucursalId(imagen.getSucursalId() != null ? imagen.getSucursalId().getValue() : null)
                .nombreArchivo(imagen.getNombreArchivo() != null ? imagen.getNombreArchivo().getValue() : null)
                .rutaArchivo(imagen.getRutaArchivo() != null ? imagen.getRutaArchivo().getValue() : null)
                .descripcion(imagen.getDescripcion() != null ? imagen.getDescripcion().getValue() : null)
                .build();
    }
}
