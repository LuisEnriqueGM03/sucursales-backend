package com.empresa.sucursales_api.infrastructure.config;
import com.empresa.sucursales_api.application.personal.port.in.ManagePersonalUseCase;
import com.empresa.sucursales_api.application.personal.service.PersonalService;
import com.empresa.sucursales_api.domain.personal.port.out.PersonalRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class PersonalConfig {
    @Bean
    public ManagePersonalUseCase managePersonalUseCase(PersonalRepositoryPort personalRepository) {
        return new PersonalService(personalRepository);
    }
}
