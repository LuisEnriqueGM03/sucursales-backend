package com.empresa.sucursales_api.infrastructure.auth.controller;

import com.empresa.sucursales_api.application.auth.dto.LoginRequest;
import com.empresa.sucursales_api.application.auth.dto.LoginResponse;
import com.empresa.sucursales_api.application.auth.dto.LogoutResponse;
import com.empresa.sucursales_api.application.auth.port.in.AuthUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthUseCase authUseCase;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authUseCase.login(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String correoInstitucional = authentication.getName();
        
        LogoutResponse response = authUseCase.logout(correoInstitucional);
        
        // Limpiar el contexto de seguridad
        SecurityContextHolder.clearContext();
        
        return ResponseEntity.ok(response);
    }
}
