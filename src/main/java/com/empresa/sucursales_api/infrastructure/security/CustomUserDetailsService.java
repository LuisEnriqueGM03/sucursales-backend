package com.empresa.sucursales_api.infrastructure.security;

import com.empresa.sucursales_api.infrastructure.personal.persistence.PersonalEntity;
import com.empresa.sucursales_api.infrastructure.personal.persistence.PersonalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    
    private final PersonalJpaRepository personalRepository;
    
    @Override
    public UserDetails loadUserByUsername(String correoInstitucional) throws UsernameNotFoundException {
        PersonalEntity personal = personalRepository.findByCorreoInstitucional(correoInstitucional)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Usuario no encontrado con correo: " + correoInstitucional));
        
        if (!personal.getIsActive()) {
            throw new UsernameNotFoundException("Usuario inactivo: " + correoInstitucional);
        }
        
        // Mapear el cargo a rol ROLE_<CARGO>
        String role = "ROLE_" + personal.getCargo().name();
        
        return User.builder()
                .username(personal.getCorreoInstitucional())
                .password(personal.getPassword())
                .authorities(Collections.singletonList(new SimpleGrantedAuthority(role)))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!personal.getIsActive())
                .build();
    }
}
