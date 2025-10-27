package com.empresa.sucursales_api.infrastructure.numerocorporativo.controller;
import com.empresa.sucursales_api.application.numerocorporativo.dto.NumeroCorporativoRequest;
import com.empresa.sucursales_api.application.numerocorporativo.dto.NumeroCorporativoResponse;
import com.empresa.sucursales_api.application.numerocorporativo.dto.NumeroCorporativoUpdateRequest;
import com.empresa.sucursales_api.application.numerocorporativo.port.in.ManageNumeroCorporativoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/numeros-corporativos")
@RequiredArgsConstructor
public class NumeroCorporativoController {
    private final ManageNumeroCorporativoUseCase manageNumeroCorporativoUseCase;
    @PostMapping
    public ResponseEntity<NumeroCorporativoResponse> createNumero(@Valid @RequestBody NumeroCorporativoRequest request) {
        NumeroCorporativoResponse response = manageNumeroCorporativoUseCase.createNumero(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<NumeroCorporativoResponse> getNumeroById(@PathVariable Long id) {
        NumeroCorporativoResponse response = manageNumeroCorporativoUseCase.getNumeroById(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/numero/{numero}")
    public ResponseEntity<NumeroCorporativoResponse> getNumeroByNumero(@PathVariable String numero) {
        NumeroCorporativoResponse response = manageNumeroCorporativoUseCase.getNumeroByNumero(numero);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<NumeroCorporativoResponse>> getAllNumeros() {
        List<NumeroCorporativoResponse> numeros = manageNumeroCorporativoUseCase.getAllNumeros();
        return ResponseEntity.ok(numeros);
    }
    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<NumeroCorporativoResponse>> getNumerosBySucursalId(@PathVariable Long sucursalId) {
        List<NumeroCorporativoResponse> numeros = manageNumeroCorporativoUseCase.getNumerosBySucursalId(sucursalId);
        return ResponseEntity.ok(numeros);
    }
    @GetMapping("/personal/{personalId}")
    public ResponseEntity<List<NumeroCorporativoResponse>> getNumerosByPersonalId(@PathVariable Long personalId) {
        List<NumeroCorporativoResponse> numeros = manageNumeroCorporativoUseCase.getNumerosByPersonalId(personalId);
        return ResponseEntity.ok(numeros);
    }
    @PutMapping("/{id}")
    public ResponseEntity<NumeroCorporativoResponse> updateNumero(
            @PathVariable Long id,
            @Valid @RequestBody NumeroCorporativoUpdateRequest request) {
        NumeroCorporativoResponse response = manageNumeroCorporativoUseCase.updateNumero(id, request);
        return ResponseEntity.ok(response);
    }
    @PatchMapping("/{id}/assign/{personalId}")
    public ResponseEntity<NumeroCorporativoResponse> assignToPersonal(
            @PathVariable Long id,
            @PathVariable Long personalId) {
        NumeroCorporativoResponse response = manageNumeroCorporativoUseCase.assignToPersonal(id, personalId);
        return ResponseEntity.ok(response);
    }
    @PatchMapping("/{id}/unassign")
    public ResponseEntity<NumeroCorporativoResponse> unassignFromPersonal(@PathVariable Long id) {
        NumeroCorporativoResponse response = manageNumeroCorporativoUseCase.unassignFromPersonal(id);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNumero(@PathVariable Long id) {
        manageNumeroCorporativoUseCase.deleteNumero(id);
        return ResponseEntity.noContent().build();
    }
}
