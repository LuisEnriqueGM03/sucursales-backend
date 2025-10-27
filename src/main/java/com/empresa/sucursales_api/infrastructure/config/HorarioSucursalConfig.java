package com.empresa.sucursales_api.infrastructure.config;
import com.empresa.sucursales_api.infrastructure.horariosucursal.persistence.HorarioSucursalMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class HorarioSucursalConfig {
    @Bean
    public HorarioSucursalMapper horarioSucursalMapper() {
        return new HorarioSucursalMapper();
    }
}
