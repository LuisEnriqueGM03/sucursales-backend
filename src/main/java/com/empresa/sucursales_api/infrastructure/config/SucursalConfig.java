package com.empresa.sucursales_api.infrastructure.config;

import com.empresa.sucursales_api.application.horariosucursal.port.out.HorarioSucursalRepositoryPort;
import com.empresa.sucursales_api.application.sucursal.port.in.CreateSucursalUseCase;
import com.empresa.sucursales_api.application.sucursal.port.in.DeleteSucursalUseCase;
import com.empresa.sucursales_api.application.sucursal.port.in.GetSucursalUseCase;
import com.empresa.sucursales_api.application.sucursal.port.in.UpdateSucursalUseCase;
import com.empresa.sucursales_api.application.sucursal.port.out.SucursalRepositoryPort;
import com.empresa.sucursales_api.application.sucursal.service.SucursalService;
import com.empresa.sucursales_api.domain.contactosucursal.port.out.ContactoSucursalRepositoryPort;
import com.empresa.sucursales_api.infrastructure.sucursal.persistence.SucursalMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de beans para la aplicación de Sucursales
 */
@Configuration
public class SucursalConfig {
    
    @Bean
    public SucursalMapper sucursalMapper() {
        return new SucursalMapper();
    }
    
    @Bean
    public SucursalService sucursalService(
            SucursalRepositoryPort repositoryPort,
            HorarioSucursalRepositoryPort horarioRepositoryPort,
            ContactoSucursalRepositoryPort contactoRepositoryPort) {
        return new SucursalService(repositoryPort, horarioRepositoryPort, contactoRepositoryPort);
    }
}
