package com.sigfarma.sigfarma_api.modules.user.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "Usuarios")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nombres;

    @Column(nullable = false, length = 255)
    private String apellidos;

    @Column(nullable = false, unique = true, length = 8)
    private String dni;

    @Column(length = 9)
    private String celular;

    @Column(nullable = false, unique = true, length = 150)
    private String correo;

    @Column(length = 255)
    private String direccion;

    @Column(nullable = false, length = 255)
    private String contrasenia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_rol_id", nullable = false)
    private TypeRol tipoRol;

    @Column(name = "creado", nullable = false, updatable = false)
    private LocalDateTime creado;

    @PrePersist
    protected void onCreate() {
        this.creado = LocalDateTime.now(); // Se asigna la fecha/hora automática antes de guardar
    }
}
