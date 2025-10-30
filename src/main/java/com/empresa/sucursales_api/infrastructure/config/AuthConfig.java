package com.empresa.sucursales_api.infrastructure.config;

import com.empresa.sucursales_api.application.auth.port.in.AuthUseCase;
import com.empresa.sucursales_api.application.auth.service.AuthService;
import com.empresa.sucursales_api.infrastructure.personal.persistence.PersonalJpaRepository;
import com.empresa.sucursales_api.infrastructure.security.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class AuthConfig {
    
    @Bean
    public AuthUseCase authUseCase(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            PersonalJpaRepository personalRepository) {
        return new AuthService(authenticationManager, jwtService, personalRepository);
    }
}
