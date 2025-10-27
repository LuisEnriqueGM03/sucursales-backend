package com.empresa.sucursales_api.application.sucursal.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SucursalRequest {
    private String direccion;
    private String telefonoPrincipal;
    private BigDecimal latitud;
    private BigDecimal longitud;
}
