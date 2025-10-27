package com.empresa.sucursales_api.infrastructure.contactosucursal.controllers;
import com.empresa.sucursales_api.application.contactosucursal.dto.ContactoSucursalRequest;
import com.empresa.sucursales_api.application.contactosucursal.dto.ContactoSucursalResponse;
import com.empresa.sucursales_api.application.contactosucursal.dto.ContactoSucursalUpdateRequest;
import com.empresa.sucursales_api.application.contactosucursal.port.in.ManageContactoSucursalUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/contactos-sucursal")
@RequiredArgsConstructor
public class ContactoSucursalController {
    private final ManageContactoSucursalUseCase manageContactoUseCase;
    @PostMapping
    public ResponseEntity<ContactoSucursalResponse> createContacto(@Valid @RequestBody ContactoSucursalRequest request) {
        ContactoSucursalResponse response = manageContactoUseCase.createContacto(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactoSucursalResponse> getContactoById(@PathVariable Long id) {
        ContactoSucursalResponse response = manageContactoUseCase.getContactoById(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<ContactoSucursalResponse>> getAllContactos() {
        List<ContactoSucursalResponse> responses = manageContactoUseCase.getAllContactos();
        return ResponseEntity.ok(responses);
    }
    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<ContactoSucursalResponse>> getContactosBySucursal(@PathVariable Long sucursalId) {
        List<ContactoSucursalResponse> responses = manageContactoUseCase.getContactosBySucursalId(sucursalId);
        return ResponseEntity.ok(responses);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContactoSucursalResponse> updateContacto(
            @PathVariable Long id,
            @Valid @RequestBody ContactoSucursalUpdateRequest request) {
        ContactoSucursalResponse response = manageContactoUseCase.updateContacto(id, request);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContacto(@PathVariable Long id) {
        manageContactoUseCase.deleteContacto(id);
        return ResponseEntity.noContent().build();
    }
}
