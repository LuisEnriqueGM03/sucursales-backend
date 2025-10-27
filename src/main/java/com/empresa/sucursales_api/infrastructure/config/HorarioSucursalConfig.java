package com.empresa.sucursales_api.infrastructure.config;

import com.empresa.sucursales_api.infrastructure.horariosucursal.persistence.HorarioSucursalMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de beans para el módulo de HorarioSucursal
 */
@Configuration
public class HorarioSucursalConfig {
    
    @Bean
    public HorarioSucursalMapper horarioSucursalMapper() {
        return new HorarioSucursalMapper();
    }
}
