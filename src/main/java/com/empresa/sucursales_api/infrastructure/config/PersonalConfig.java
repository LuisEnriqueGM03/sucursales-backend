package com.empresa.sucursales_api.infrastructure.config;
import com.empresa.sucursales_api.application.personal.port.in.ManagePersonalUseCase;
import com.empresa.sucursales_api.application.personal.service.PersonalService;
import com.empresa.sucursales_api.domain.personal.port.out.PersonalRepositoryPort;
import com.empresa.sucursales_api.domain.telefonopersonal.port.out.TelefonoPersonalRepositoryPort;
import com.empresa.sucursales_api.domain.numerocorporativo.port.out.NumeroCorporativoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PersonalConfig {
    @Bean
    public ManagePersonalUseCase managePersonalUseCase(
            PersonalRepositoryPort personalRepository,
            BCryptPasswordEncoder passwordEncoder,
            TelefonoPersonalRepositoryPort telefonoPersonalRepositoryPort,
            NumeroCorporativoRepositoryPort numeroCorporativoRepositoryPort) {
        return new PersonalService(personalRepository, passwordEncoder, telefonoPersonalRepositoryPort, numeroCorporativoRepositoryPort);
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
