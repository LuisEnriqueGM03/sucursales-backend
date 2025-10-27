package com.empresa.sucursales_api.infrastructure.personal.persistence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Entity
@Table(name = "personal")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_completo", nullable = false, length = 150)
    private String nombreCompleto;
    @Column(name = "cargo", length = 100)
    private String cargo;
    @Column(name = "correo_institucional", nullable = false, unique = true, length = 150)
    private String correoInstitucional;
    @Column(name = "sucursal_id")
    private Long sucursalId;
    @Column(name = "is_active")
    @Builder.Default
    private Boolean isActive = true;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (isActive == null) {
            isActive = true;
        }
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
