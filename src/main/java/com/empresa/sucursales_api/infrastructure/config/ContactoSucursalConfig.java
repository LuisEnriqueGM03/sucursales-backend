package com.empresa.sucursales_api.infrastructure.config;

import com.empresa.sucursales_api.application.contactosucursal.port.in.ManageContactoSucursalUseCase;
import com.empresa.sucursales_api.application.contactosucursal.service.ContactoSucursalService;
import com.empresa.sucursales_api.domain.contactosucursal.port.out.ContactoSucursalRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de beans para el módulo de ContactoSucursal
 */
@Configuration
public class ContactoSucursalConfig {

    @Bean
    public ManageContactoSucursalUseCase manageContactoSucursalUseCase(
            ContactoSucursalRepositoryPort contactoRepository) {
        return new ContactoSucursalService(contactoRepository);
    }
}
