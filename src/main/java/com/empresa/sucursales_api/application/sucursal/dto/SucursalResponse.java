package com.empresa.sucursales_api.application.sucursal.dto;
import com.empresa.sucursales_api.application.contactosucursal.dto.ContactoSucursalResponse;
import com.empresa.sucursales_api.application.horariosucursal.dto.HorarioSucursalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SucursalResponse {
    private Long id;
    private String direccion;
    private String telefonoPrincipal;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private List<HorarioSucursalResponse> horarios;
    private List<ContactoSucursalResponse> contactos;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
