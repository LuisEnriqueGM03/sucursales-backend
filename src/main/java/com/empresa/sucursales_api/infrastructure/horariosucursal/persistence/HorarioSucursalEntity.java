package com.empresa.sucursales_api.infrastructure.horariosucursal.persistence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
@Entity
@Table(name = "horarios_sucursal")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HorarioSucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sucursal_id", nullable = false)
    private Long sucursalId;
    @Column(name = "dia_semana", nullable = false, length = 15)
    private String diaSemana;
    @Column(name = "hora_apertura", nullable = false)
    private LocalTime horaApertura;
    @Column(name = "hora_cierre", nullable = false)
    private LocalTime horaCierre;
}
