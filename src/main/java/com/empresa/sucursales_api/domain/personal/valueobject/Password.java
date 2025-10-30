package com.empresa.sucursales_api.domain.personal.valueobject;

import lombok.Value;

@Value
public class Password {
    String hashedValue;
    
    public static Password of(String hashedPassword) {
        if (hashedPassword == null || hashedPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("El password no puede estar vacío");
        }
        return new Password(hashedPassword);
    }
    
    public static Password ofPlainText(String plainPassword) {
        if (plainPassword == null || plainPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("El password no puede estar vacío");
        }
        
        if (plainPassword.length() < 6) {
            throw new IllegalArgumentException("El password debe tener al menos 6 caracteres");
        }
        
        if (plainPassword.length() > 100) {
            throw new IllegalArgumentException("El password no puede exceder 100 caracteres");
        }
        
        // El hash se hará en la capa de infraestructura
        return new Password(plainPassword);
    }
}
