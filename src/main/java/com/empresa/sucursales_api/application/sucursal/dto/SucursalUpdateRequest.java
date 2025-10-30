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
public class SucursalUpdateRequest {
    private String nombre;
    private String direccion;
    private String telefonoPrincipal;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private Boolean active;
}
