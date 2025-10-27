package com.empresa.sucursales_api.application.horariosucursal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * DTO para actualizar un horario de sucursal existente
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HorarioSucursalUpdateRequest {
    private String diaSemana;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
}
