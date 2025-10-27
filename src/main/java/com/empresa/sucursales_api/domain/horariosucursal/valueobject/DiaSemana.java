package com.empresa.sucursales_api.domain.horariosucursal.valueobject;
import lombok.Getter;
@Getter
public enum DiaSemana {
    LUNES("Lunes"),
    MARTES("Martes"),
    MIERCOLES("MiÃ©rcoles"),
    JUEVES("Jueves"),
    VIERNES("Viernes"),
    SABADO("SÃ¡bado"),
    DOMINGO("Domingo");
    private final String nombre;
    DiaSemana(String nombre) {
        this.nombre = nombre;
    }
    public static DiaSemana fromString(String dia) {
        if (dia == null || dia.trim().isEmpty()) {
            throw new IllegalArgumentException("El dÃ­a de la semana no puede ser nulo o vacÃ­o");
        }
        String diaUpper = dia.trim().toUpperCase();
        try {
            return DiaSemana.valueOf(diaUpper);
        } catch (IllegalArgumentException e) {
            for (DiaSemana d : DiaSemana.values()) {
                if (d.getNombre().equalsIgnoreCase(dia.trim())) {
                    return d;
                }
            }
            throw new IllegalArgumentException("DÃ­a de semana invÃ¡lido: " + dia + 
                    ". Valores permitidos: Lunes, Martes, MiÃ©rcoles, Jueves, Viernes, SÃ¡bado, Domingo");
        }
    }
}
