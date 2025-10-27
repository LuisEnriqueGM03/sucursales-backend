package com.empresa.sucursales_api.infrastructure.config;
import com.empresa.sucursales_api.application.numerocorporativo.port.in.ManageNumeroCorporativoUseCase;
import com.empresa.sucursales_api.application.numerocorporativo.service.NumeroCorporativoService;
import com.empresa.sucursales_api.domain.numerocorporativo.port.out.NumeroCorporativoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class NumeroCorporativoConfig {
    @Bean
    public ManageNumeroCorporativoUseCase manageNumeroCorporativoUseCase(
            NumeroCorporativoRepositoryPort numeroCorporativoRepositoryPort) {
        return new NumeroCorporativoService(numeroCorporativoRepositoryPort);
    }
}
