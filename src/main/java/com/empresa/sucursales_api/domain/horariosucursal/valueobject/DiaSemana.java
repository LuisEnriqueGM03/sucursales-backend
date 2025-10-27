package com.empresa.sucursales_api.domain.horariosucursal.valueobject;

import lombok.Getter;

/**
 * Enum que representa los días de la semana
 */
@Getter
public enum DiaSemana {
    LUNES("Lunes"),
    MARTES("Martes"),
    MIERCOLES("Miércoles"),
    JUEVES("Jueves"),
    VIERNES("Viernes"),
    SABADO("Sábado"),
    DOMINGO("Domingo");
    
    private final String nombre;
    
    DiaSemana(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Convierte un string a DiaSemana
     */
    public static DiaSemana fromString(String dia) {
        if (dia == null || dia.trim().isEmpty()) {
            throw new IllegalArgumentException("El día de la semana no puede ser nulo o vacío");
        }
        
        String diaUpper = dia.trim().toUpperCase();
        
        // Intenta matchear con el enum
        try {
            return DiaSemana.valueOf(diaUpper);
        } catch (IllegalArgumentException e) {
            // Intenta matchear por el nombre amigable
            for (DiaSemana d : DiaSemana.values()) {
                if (d.getNombre().equalsIgnoreCase(dia.trim())) {
                    return d;
                }
            }
            throw new IllegalArgumentException("Día de semana inválido: " + dia + 
                    ". Valores permitidos: Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo");
        }
    }
}
