package com.empresa.sucursales_api.domain.sucursal.model;
import com.empresa.sucursales_api.domain.contactosucursal.model.ContactoSucursal;
import com.empresa.sucursales_api.domain.horariosucursal.model.HorarioSucursal;
import com.empresa.sucursales_api.domain.imagensucursal.model.ImagenSucursal;
import com.empresa.sucursales_api.domain.sucursal.valueobject.Coordenadas;
import com.empresa.sucursales_api.domain.sucursal.valueobject.SucursalId;
import com.empresa.sucursales_api.domain.sucursal.valueobject.Direccion;
import com.empresa.sucursales_api.domain.sucursal.valueobject.TelefonoPrincipal;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import java.time.LocalDateTime;
import java.util.List;
@Value
@Builder
@With
public class Sucursal {
    SucursalId id;
    String nombre;
    Direccion direccion;
    TelefonoPrincipal telefonoPrincipal;
    Coordenadas coordenadas;
    List<HorarioSucursal> horarios;
    List<ContactoSucursal> contactos;
    List<ImagenSucursal> imagenes;
    boolean active;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
