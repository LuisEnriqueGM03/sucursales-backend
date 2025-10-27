package com.empresa.sucursales_api.infrastructure.config;
import com.empresa.sucursales_api.application.imagensucursal.port.in.ManageImagenSucursalUseCase;
import com.empresa.sucursales_api.application.imagensucursal.service.ImagenSucursalService;
import com.empresa.sucursales_api.domain.imagensucursal.port.out.ImagenSucursalRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ImagenSucursalConfig {
    @Bean
    public ManageImagenSucursalUseCase manageImagenSucursalUseCase(
            ImagenSucursalRepositoryPort imagenSucursalRepositoryPort) {
        return new ImagenSucursalService(imagenSucursalRepositoryPort);
    }
}
