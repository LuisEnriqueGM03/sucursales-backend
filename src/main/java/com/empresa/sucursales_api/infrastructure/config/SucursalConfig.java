package com.empresa.sucursales_api.infrastructure.config;
import com.empresa.sucursales_api.application.horariosucursal.port.out.HorarioSucursalRepositoryPort;
import com.empresa.sucursales_api.application.sucursal.port.out.SucursalRepositoryPort;
import com.empresa.sucursales_api.application.sucursal.service.SucursalService;
import com.empresa.sucursales_api.domain.contactosucursal.port.out.ContactoSucursalRepositoryPort;
import com.empresa.sucursales_api.domain.imagensucursal.port.out.ImagenSucursalRepositoryPort;
import com.empresa.sucursales_api.domain.numerocorporativo.port.out.NumeroCorporativoRepositoryPort;
import com.empresa.sucursales_api.domain.personal.port.out.PersonalRepositoryPort;
import com.empresa.sucursales_api.infrastructure.sucursal.persistence.SucursalMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
            ContactoSucursalRepositoryPort contactoRepositoryPort,
            ImagenSucursalRepositoryPort imagenRepositoryPort,
            PersonalRepositoryPort personalRepositoryPort,
            NumeroCorporativoRepositoryPort numeroCorporativoRepositoryPort) {
        return new SucursalService(repositoryPort, horarioRepositoryPort, contactoRepositoryPort, imagenRepositoryPort, personalRepositoryPort, numeroCorporativoRepositoryPort);
    }
}
