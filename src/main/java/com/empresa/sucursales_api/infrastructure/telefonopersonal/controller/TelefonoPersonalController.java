package com.empresa.sucursales_api.infrastructure.telefonopersonal.controller;
import com.empresa.sucursales_api.application.telefonopersonal.dto.TelefonoPersonalRequest;
import com.empresa.sucursales_api.application.telefonopersonal.dto.TelefonoPersonalResponse;
import com.empresa.sucursales_api.application.telefonopersonal.dto.TelefonoPersonalUpdateRequest;
import com.empresa.sucursales_api.application.telefonopersonal.port.in.ManageTelefonoPersonalUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/telefonos-personal")
@RequiredArgsConstructor
public class TelefonoPersonalController {
    private final ManageTelefonoPersonalUseCase manageTelefonoPersonalUseCase;
    @PostMapping
    public ResponseEntity<TelefonoPersonalResponse> createTelefono(@Valid @RequestBody TelefonoPersonalRequest request) {
        TelefonoPersonalResponse response = manageTelefonoPersonalUseCase.createTelefono(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TelefonoPersonalResponse> getTelefonoById(@PathVariable Long id) {
        TelefonoPersonalResponse response = manageTelefonoPersonalUseCase.getTelefonoById(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<TelefonoPersonalResponse>> getAllTelefonos() {
        List<TelefonoPersonalResponse> telefonos = manageTelefonoPersonalUseCase.getAllTelefonos();
        return ResponseEntity.ok(telefonos);
    }
    @GetMapping("/personal/{personalId}")
    public ResponseEntity<List<TelefonoPersonalResponse>> getTelefonosByPersonalId(@PathVariable Long personalId) {
        List<TelefonoPersonalResponse> telefonos = manageTelefonoPersonalUseCase.getTelefonosByPersonalId(personalId);
        return ResponseEntity.ok(telefonos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TelefonoPersonalResponse> updateTelefono(
            @PathVariable Long id,
            @Valid @RequestBody TelefonoPersonalUpdateRequest request) {
        TelefonoPersonalResponse response = manageTelefonoPersonalUseCase.updateTelefono(id, request);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelefono(@PathVariable Long id) {
        manageTelefonoPersonalUseCase.deleteTelefono(id);
        return ResponseEntity.noContent().build();
    }
}
