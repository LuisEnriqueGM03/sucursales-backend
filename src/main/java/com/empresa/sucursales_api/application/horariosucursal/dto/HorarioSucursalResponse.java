package com.empresa.sucursales_api.application.horariosucursal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * DTO para la respuesta de un horario de sucursal
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HorarioSucursalResponse {
    private Long id;
    private Long sucursalId;
    private String diaSemana;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
}
