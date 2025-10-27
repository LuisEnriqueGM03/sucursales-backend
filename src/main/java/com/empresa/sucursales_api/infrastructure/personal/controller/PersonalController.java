package com.empresa.sucursales_api.infrastructure.personal.controller;

import com.empresa.sucursales_api.application.personal.dto.PersonalRequest;
import com.empresa.sucursales_api.application.personal.dto.PersonalResponse;
import com.empresa.sucursales_api.application.personal.dto.PersonalUpdateRequest;
import com.empresa.sucursales_api.application.personal.port.in.ManagePersonalUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar el personal
 */
@RestController
@RequestMapping("/api/personal")
@RequiredArgsConstructor
public class PersonalController {

    private final ManagePersonalUseCase managePersonalUseCase;

    @PostMapping
    public ResponseEntity<PersonalResponse> createPersonal(@Valid @RequestBody PersonalRequest request) {
        PersonalResponse response = managePersonalUseCase.createPersonal(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalResponse> getPersonalById(@PathVariable Long id) {
        PersonalResponse response = managePersonalUseCase.getPersonalById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PersonalResponse>> getAllPersonal(@RequestParam(required = false, defaultValue = "false") boolean onlyActive) {
        List<PersonalResponse> responses = onlyActive ? 
                managePersonalUseCase.getActivePersonal() : 
                managePersonalUseCase.getAllPersonal();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<PersonalResponse>> getPersonalBySucursal(@PathVariable Long sucursalId) {
        List<PersonalResponse> responses = managePersonalUseCase.getPersonalBySucursalId(sucursalId);
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalResponse> updatePersonal(
            @PathVariable Long id,
            @Valid @RequestBody PersonalUpdateRequest request) {
        PersonalResponse response = managePersonalUseCase.updatePersonal(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonal(@PathVariable Long id) {
        managePersonalUseCase.deletePersonal(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivatePersonal(@PathVariable Long id) {
        managePersonalUseCase.deactivatePersonal(id);
        return ResponseEntity.noContent().build();
    }
}
