package com.empresa.sucursales_api.infrastructure.numerocorporativo.persistence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Entity
@Table(name = "numeros_corporativos", 
       uniqueConstraints = {
           @UniqueConstraint(name = "uk_numero", columnNames = "numero"),
           @UniqueConstraint(name = "unq_sucursal_num", columnNames = {"sucursal_id", "numero"})
       })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NumeroCorporativoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero", nullable = false, unique = true, length = 30)
    private String numero;
    @Column(name = "sucursal_id", nullable = false)
    private Long sucursalId;
    @Column(name = "personal_id")
    private Long personalId;
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
