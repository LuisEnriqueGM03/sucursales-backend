package com.empresa.sucursales_api.infrastructure.contactosucursal.persistence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Entity
@Table(name = "contactos_sucursal")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactoSucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sucursal_id", nullable = false)
    private Long sucursalId;
    @Column(name = "numero", nullable = false, length = 30)
    private String numero;
    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;
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
