package com.empresa.sucursales_api.application.imagensucursal.port.in;
import com.empresa.sucursales_api.application.imagensucursal.dto.ImagenSucursalRequest;
import com.empresa.sucursales_api.application.imagensucursal.dto.ImagenSucursalResponse;
import com.empresa.sucursales_api.application.imagensucursal.dto.ImagenSucursalUpdateRequest;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
public interface ManageImagenSucursalUseCase {
    ImagenSucursalResponse uploadImagen(ImagenSucursalRequest request, MultipartFile file);
    ImagenSucursalResponse getImagenById(Long id);
    List<ImagenSucursalResponse> getAllImagenes();
    List<ImagenSucursalResponse> getImagenesBySucursalId(Long sucursalId);
    ImagenSucursalResponse updateDescripcion(Long id, ImagenSucursalUpdateRequest request);
    void deleteImagen(Long id);
}
