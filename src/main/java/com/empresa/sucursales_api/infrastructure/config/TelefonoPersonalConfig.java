package com.empresa.sucursales_api.infrastructure.config;

import com.empresa.sucursales_api.application.telefonopersonal.port.in.ManageTelefonoPersonalUseCase;
import com.empresa.sucursales_api.application.telefonopersonal.service.TelefonoPersonalService;
import com.empresa.sucursales_api.domain.telefonopersonal.port.out.TelefonoPersonalRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de beans para el módulo TelefonoPersonal
 */
@Configuration
public class TelefonoPersonalConfig {
    
    @Bean
    public ManageTelefonoPersonalUseCase manageTelefonoPersonalUseCase(
            TelefonoPersonalRepositoryPort telefonoPersonalRepositoryPort) {
        return new TelefonoPersonalService(telefonoPersonalRepositoryPort);
    }
}
