package com.empresa.sucursales_api.application.auth.service;

import com.empresa.sucursales_api.application.auth.dto.LoginRequest;
import com.empresa.sucursales_api.application.auth.dto.LoginResponse;
import com.empresa.sucursales_api.application.auth.dto.LogoutResponse;
import com.empresa.sucursales_api.application.auth.port.in.AuthUseCase;
import com.empresa.sucursales_api.infrastructure.personal.persistence.PersonalEntity;
import com.empresa.sucursales_api.infrastructure.personal.persistence.PersonalJpaRepository;
import com.empresa.sucursales_api.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService implements AuthUseCase {
    
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PersonalJpaRepository personalRepository;
    
    @Override
    public LoginResponse login(LoginRequest request) {
        // Autenticar usuario
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getCorreoInstitucional(),
                        request.getPassword()
                )
        );
        
        // Generar token
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);
        
        // Obtener información del personal
        PersonalEntity personal = personalRepository.findByCorreoInstitucional(request.getCorreoInstitucional())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        return LoginResponse.builder()
                .token(token)
                .type("Bearer")
                .correoInstitucional(personal.getCorreoInstitucional())
                .nombreCompleto(personal.getNombreCompleto())
                .cargo(personal.getCargo() != null ? personal.getCargo().getDisplayName() : null)
                .sucursalId(personal.getSucursalId())
                .build();
    }
    
    @Override
    public LogoutResponse logout(String correoInstitucional) {
        // Logout simple sin blacklist - solo limpiamos el contexto de seguridad
        // El token seguirá siendo válido hasta su expiración
        // El cliente debe eliminar el token de su almacenamiento local
        
        return LogoutResponse.builder()
                .message("Sesión cerrada exitosamente. Por favor elimine el token de su almacenamiento local.")
                .correoInstitucional(correoInstitucional)
                .build();
    }
}
