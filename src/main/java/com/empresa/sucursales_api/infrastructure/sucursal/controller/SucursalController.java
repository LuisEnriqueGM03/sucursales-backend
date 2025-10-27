package com.empresa.sucursales_api.infrastructure.sucursal.controller;

import com.empresa.sucursales_api.application.sucursal.dto.SucursalRequest;
import com.empresa.sucursales_api.application.sucursal.dto.SucursalResponse;
import com.empresa.sucursales_api.application.sucursal.dto.SucursalUpdateRequest;
import com.empresa.sucursales_api.application.sucursal.port.in.CreateSucursalUseCase;
import com.empresa.sucursales_api.application.sucursal.port.in.DeleteSucursalUseCase;
import com.empresa.sucursales_api.application.sucursal.port.in.GetSucursalUseCase;
import com.empresa.sucursales_api.application.sucursal.port.in.UpdateSucursalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para las operaciones CRUD de Sucursales
 */
@RestController
@RequestMapping("/api/sucursales")
@RequiredArgsConstructor
public class SucursalController {
    
    private final CreateSucursalUseCase createSucursalUseCase;
    private final GetSucursalUseCase getSucursalUseCase;
    private final UpdateSucursalUseCase updateSucursalUseCase;
    private final DeleteSucursalUseCase deleteSucursalUseCase;
    
    @PostMapping
    public ResponseEntity<SucursalResponse> createSucursal(@RequestBody SucursalRequest request) {
        SucursalResponse response = createSucursalUseCase.createSucursal(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SucursalResponse> getSucursalById(@PathVariable Long id) {
        SucursalResponse response = getSucursalUseCase.getSucursalById(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<List<SucursalResponse>> getAllSucursales(
            @RequestParam(required = false, defaultValue = "false") boolean onlyActive) {
        List<SucursalResponse> responses = onlyActive 
                ? getSucursalUseCase.getActiveSucursales()
                : getSucursalUseCase.getAllSucursales();
        return ResponseEntity.ok(responses);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SucursalResponse> updateSucursal(
            @PathVariable Long id, 
            @RequestBody SucursalUpdateRequest request) {
        SucursalResponse response = updateSucursalUseCase.updateSucursal(id, request);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable Long id) {
        deleteSucursalUseCase.deleteSucursal(id);
        return ResponseEntity.noContent().build();
    }
    
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateSucursal(@PathVariable Long id) {
        deleteSucursalUseCase.deactivateSucursal(id);
        return ResponseEntity.noContent().build();
    }
}
