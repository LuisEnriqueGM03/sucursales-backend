package com.empresa.sucursales_api.infrastructure.imagensucursal.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entidad JPA para la tabla imagenes_sucursal
 */
@Entity
@Table(name = "imagenes_sucursal")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImagenSucursalEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "sucursal_id", nullable = false)
    private Long sucursalId;
    
    @Column(name = "nombre_archivo", nullable = false, length = 255)
    private String nombreArchivo;
    
    @Column(name = "ruta_archivo", nullable = false, columnDefinition = "TEXT")
    private String rutaArchivo;
    
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
