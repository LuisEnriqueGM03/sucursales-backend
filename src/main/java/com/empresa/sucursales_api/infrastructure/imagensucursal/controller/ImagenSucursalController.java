package com.empresa.sucursales_api.infrastructure.imagensucursal.controller;
import com.empresa.sucursales_api.application.imagensucursal.dto.ImagenSucursalRequest;
import com.empresa.sucursales_api.application.imagensucursal.dto.ImagenSucursalResponse;
import com.empresa.sucursales_api.application.imagensucursal.dto.ImagenSucursalUpdateRequest;
import com.empresa.sucursales_api.application.imagensucursal.port.in.ManageImagenSucursalUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
@RestController
@RequestMapping("/api/imagenes-sucursal")
@RequiredArgsConstructor
public class ImagenSucursalController {
    private final ManageImagenSucursalUseCase manageImagenSucursalUseCase;
    @PostMapping
    public ResponseEntity<ImagenSucursalResponse> uploadImagen(
            @RequestParam("file") MultipartFile file,
            @RequestParam("sucursalId") Long sucursalId,
            @RequestParam(value = "descripcion", required = false) String descripcion) {
        ImagenSucursalRequest request = new ImagenSucursalRequest(sucursalId, descripcion);
        ImagenSucursalResponse response = manageImagenSucursalUseCase.uploadImagen(request, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ImagenSucursalResponse> getImagenById(@PathVariable Long id) {
        ImagenSucursalResponse response = manageImagenSucursalUseCase.getImagenById(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<ImagenSucursalResponse>> getAllImagenes() {
        List<ImagenSucursalResponse> imagenes = manageImagenSucursalUseCase.getAllImagenes();
        return ResponseEntity.ok(imagenes);
    }
    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<ImagenSucursalResponse>> getImagenesBySucursalId(@PathVariable Long sucursalId) {
        List<ImagenSucursalResponse> imagenes = manageImagenSucursalUseCase.getImagenesBySucursalId(sucursalId);
        return ResponseEntity.ok(imagenes);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ImagenSucursalResponse> updateDescripcion(
            @PathVariable Long id,
            @Valid @RequestBody ImagenSucursalUpdateRequest request) {
        ImagenSucursalResponse response = manageImagenSucursalUseCase.updateDescripcion(id, request);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImagen(@PathVariable Long id) {
        manageImagenSucursalUseCase.deleteImagen(id);
        return ResponseEntity.noContent().build();
    }
}
