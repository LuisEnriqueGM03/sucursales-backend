package com.empresa.sucursales_api.infrastructure.horariosucursal.controllers;

import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalRequest;
import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalResponse;
import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalUpdateRequest;
import com.empresa.sucursales_api.application.horariosucursal.port.in.CreateHorarioSucursalUseCase;
import com.empresa.sucursales_api.application.horariosucursal.port.in.DeleteHorarioSucursalUseCase;
import com.empresa.sucursales_api.application.horariosucursal.port.in.GetHorarioSucursalUseCase;
import com.empresa.sucursales_api.application.horariosucursal.port.in.UpdateHorarioSucursalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de horarios de sucursales
 */
@RestController
@RequestMapping("/api/horarios-sucursales")
@RequiredArgsConstructor
public class HorarioSucursalController {
    
    private final CreateHorarioSucursalUseCase createUseCase;
    private final GetHorarioSucursalUseCase getUseCase;
    private final UpdateHorarioSucursalUseCase updateUseCase;
    private final DeleteHorarioSucursalUseCase deleteUseCase;
    
    /**
     * Crear un nuevo horario de sucursal
     */
    @PostMapping
    public ResponseEntity<HorarioSucursalResponse> createHorarioSucursal(
            @RequestBody HorarioSucursalRequest request) {
        HorarioSucursalResponse response = createUseCase.createHorarioSucursal(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    /**
     * Obtener un horario por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<HorarioSucursalResponse> getHorarioSucursalById(@PathVariable Long id) {
        HorarioSucursalResponse response = getUseCase.getHorarioSucursalById(id);
        return ResponseEntity.ok(response);
    }
    
    /**
     * Obtener todos los horarios
     */
    @GetMapping
    public ResponseEntity<List<HorarioSucursalResponse>> getAllHorariosSucursales() {
        List<HorarioSucursalResponse> responses = getUseCase.getAllHorariosSucursales();
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Obtener todos los horarios de una sucursal específica
     */
    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<HorarioSucursalResponse>> getHorariosBySucursalId(
            @PathVariable Long sucursalId) {
        List<HorarioSucursalResponse> responses = getUseCase.getHorariosBySucursalId(sucursalId);
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Actualizar un horario existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<HorarioSucursalResponse> updateHorarioSucursal(
            @PathVariable Long id,
            @RequestBody HorarioSucursalUpdateRequest request) {
        HorarioSucursalResponse response = updateUseCase.updateHorarioSucursal(id, request);
        return ResponseEntity.ok(response);
    }
    
    /**
     * Eliminar un horario
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorarioSucursal(@PathVariable Long id) {
        deleteUseCase.deleteHorarioSucursal(id);
        return ResponseEntity.noContent().build();
    }
}
