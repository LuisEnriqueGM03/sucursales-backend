package com.empresa.sucursales_api.infrastructure.telefonopersonal.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entidad JPA para la tabla telefonos_personal
 */
@Entity
@Table(name = "telefonos_personal")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelefonoPersonalEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "personal_id", nullable = false)
    private Long personalId;
    
    @Column(name = "numero", nullable = false, length = 30)
    private String numero;
    
    @Column(name = "tipo", length = 30)
    @Builder.Default
    private String tipo = "personal";
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
