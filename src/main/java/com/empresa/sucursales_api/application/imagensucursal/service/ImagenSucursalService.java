package com.empresa.sucursales_api.application.imagensucursal.service;
import com.empresa.sucursales_api.application.imagensucursal.dto.ImagenSucursalRequest;
import com.empresa.sucursales_api.application.imagensucursal.dto.ImagenSucursalResponse;
import com.empresa.sucursales_api.application.imagensucursal.dto.ImagenSucursalUpdateRequest;
import com.empresa.sucursales_api.application.imagensucursal.port.in.ManageImagenSucursalUseCase;
import com.empresa.sucursales_api.domain.imagensucursal.model.ImagenSucursal;
import com.empresa.sucursales_api.domain.imagensucursal.port.out.ImagenSucursalRepositoryPort;
import com.empresa.sucursales_api.domain.imagensucursal.valueobject.Descripcion;
import com.empresa.sucursales_api.domain.imagensucursal.valueobject.NombreArchivo;
import com.empresa.sucursales_api.domain.imagensucursal.valueobject.RutaArchivo;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@RequiredArgsConstructor
public class ImagenSucursalService implements ManageImagenSucursalUseCase {
    private final ImagenSucursalRepositoryPort imagenRepository;
    @Value("${app.upload.dir:src/main/uploads/sucursales}")
    private String uploadDir;
    @Override
    public ImagenSucursalResponse uploadImagen(ImagenSucursalRequest request, MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("El archivo estÃ¡ vacÃ­o");
        }
        try {
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename != null && originalFilename.contains(".") 
                    ? originalFilename.substring(originalFilename.lastIndexOf(".")) 
                    : "";
            String uniqueFilename = UUID.randomUUID().toString() + extension;
            Path filePath = uploadPath.resolve(uniqueFilename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            ImagenSucursal imagen = ImagenSucursal.builder()
                    .sucursalId(SucursalId.of(request.sucursalId()))
                    .nombreArchivo(NombreArchivo.of(originalFilename != null ? originalFilename : uniqueFilename))
                    .rutaArchivo(RutaArchivo.of(filePath.toString()))
                    .descripcion(Descripcion.of(request.descripcion()))
                    .build();
            ImagenSucursal savedImagen = imagenRepository.save(imagen);
            return mapToResponse(savedImagen);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo: " + e.getMessage(), e);
        }
    }
    @Override
    public ImagenSucursalResponse getImagenById(Long id) {
        return imagenRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada con id: " + id));
    }
    @Override
    public List<ImagenSucursalResponse> getAllImagenes() {
        return imagenRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    public List<ImagenSucursalResponse> getImagenesBySucursalId(Long sucursalId) {
        return imagenRepository.findBySucursalId(sucursalId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    public ImagenSucursalResponse updateDescripcion(Long id, ImagenSucursalUpdateRequest request) {
        ImagenSucursal existingImagen = imagenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada con id: " + id));
        ImagenSucursal updatedImagen = existingImagen;
        if (request.descripcion() != null) {
            updatedImagen = updatedImagen.withDescripcion(Descripcion.of(request.descripcion()));
        }
        ImagenSucursal savedImagen = imagenRepository.save(updatedImagen);
        return mapToResponse(savedImagen);
    }
    @Override
    public void deleteImagen(Long id) {
        ImagenSucursal imagen = imagenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada con id: " + id));
        try {
            Path filePath = Paths.get(imagen.getRutaArchivo().getValue());
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error al eliminar el archivo: " + e.getMessage(), e);
        }
        imagenRepository.deleteById(id);
    }
    private ImagenSucursalResponse mapToResponse(ImagenSucursal imagen) {
        return ImagenSucursalResponse.builder()
                .id(imagen.getId() != null ? imagen.getId().getValue() : null)
                .sucursalId(imagen.getSucursalId() != null ? imagen.getSucursalId().getValue() : null)
                .nombreArchivo(imagen.getNombreArchivo() != null ? imagen.getNombreArchivo().getValue() : null)
                .rutaArchivo(imagen.getRutaArchivo() != null ? imagen.getRutaArchivo().getValue() : null)
                .descripcion(imagen.getDescripcion() != null ? imagen.getDescripcion().getValue() : null)
                .build();
    }
}
