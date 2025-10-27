package com.empresa.sucursales_api.application.horariosucursal.service;
import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalRequest;
import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalResponse;
import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalUpdateRequest;
import com.empresa.sucursales_api.application.horariosucursal.port.in.CreateHorarioSucursalUseCase;
import com.empresa.sucursales_api.application.horariosucursal.port.in.DeleteHorarioSucursalUseCase;
import com.empresa.sucursales_api.application.horariosucursal.port.in.GetHorarioSucursalUseCase;
import com.empresa.sucursales_api.application.horariosucursal.port.in.UpdateHorarioSucursalUseCase;
import com.empresa.sucursales_api.application.horariosucursal.port.out.HorarioSucursalRepositoryPort;
import com.empresa.sucursales_api.domain.horariosucursal.model.HorarioSucursal;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.DiaSemana;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.HoraApertura;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.HoraCierre;
import com.empresa.sucursales_api.domain.horariosucursal.valueobject.HorarioSucursalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Transactional
public class HorarioSucursalService implements CreateHorarioSucursalUseCase, GetHorarioSucursalUseCase,
                                               UpdateHorarioSucursalUseCase, DeleteHorarioSucursalUseCase {
    private final HorarioSucursalRepositoryPort repositoryPort;
    @Override
    public HorarioSucursalResponse createHorarioSucursal(HorarioSucursalRequest request) {
        DiaSemana diaSemana = DiaSemana.fromString(request.getDiaSemana());
        HoraApertura horaApertura = HoraApertura.of(request.getHoraApertura());
        HoraCierre horaCierre = HoraCierre.of(request.getHoraCierre());
        HorarioSucursal horarioSucursal = HorarioSucursal.builder()
                .sucursalId(SucursalId.of(request.getSucursalId()))
                .diaSemana(diaSemana)
                .horaApertura(horaApertura)
                .horaCierre(horaCierre)
                .build();
        horarioSucursal.validate();
        HorarioSucursal savedHorario = repositoryPort.save(horarioSucursal);
        return mapToResponse(savedHorario);
    }
    @Override
    @Transactional(readOnly = true)
    public HorarioSucursalResponse getHorarioSucursalById(Long id) {
        HorarioSucursalId horarioId = HorarioSucursalId.of(id);
        HorarioSucursal horario = repositoryPort.findById(horarioId)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con id: " + id));
        return mapToResponse(horario);
    }
    @Override
    @Transactional(readOnly = true)
    public List<HorarioSucursalResponse> getAllHorariosSucursales() {
        return repositoryPort.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public List<HorarioSucursalResponse> getHorariosBySucursalId(Long sucursalId) {
        SucursalId id = SucursalId.of(sucursalId);
        return repositoryPort.findBySucursalId(id).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    public HorarioSucursalResponse updateHorarioSucursal(Long id, HorarioSucursalUpdateRequest request) {
        HorarioSucursalId horarioId = HorarioSucursalId.of(id);
        HorarioSucursal existingHorario = repositoryPort.findById(horarioId)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con id: " + id));
        DiaSemana diaSemana = request.getDiaSemana() != null ? 
                DiaSemana.fromString(request.getDiaSemana()) : existingHorario.getDiaSemana();
        HoraApertura horaApertura = request.getHoraApertura() != null ? 
                HoraApertura.of(request.getHoraApertura()) : existingHorario.getHoraApertura();
        HoraCierre horaCierre = request.getHoraCierre() != null ? 
                HoraCierre.of(request.getHoraCierre()) : existingHorario.getHoraCierre();
        HorarioSucursal updatedHorario = existingHorario
                .withDiaSemana(diaSemana)
                .withHoraApertura(horaApertura)
                .withHoraCierre(horaCierre);
        updatedHorario.validate();
        HorarioSucursal savedHorario = repositoryPort.save(updatedHorario);
        return mapToResponse(savedHorario);
    }
    @Override
    public void deleteHorarioSucursal(Long id) {
        HorarioSucursalId horarioId = HorarioSucursalId.of(id);
        if (!repositoryPort.existsById(horarioId)) {
            throw new RuntimeException("Horario no encontrado con id: " + id);
        }
        repositoryPort.deleteById(horarioId);
    }
    private HorarioSucursalResponse mapToResponse(HorarioSucursal horario) {
        return HorarioSucursalResponse.builder()
                .id(horario.getId() != null ? horario.getId().getValue() : null)
                .sucursalId(horario.getSucursalId() != null ? horario.getSucursalId().getValue() : null)
                .diaSemana(horario.getDiaSemana() != null ? horario.getDiaSemana().getNombre() : null)
                .horaApertura(horario.getHoraApertura() != null ? horario.getHoraApertura().getValue() : null)
                .horaCierre(horario.getHoraCierre() != null ? horario.getHoraCierre().getValue() : null)
                .build();
    }
}
