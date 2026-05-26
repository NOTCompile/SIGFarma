package com.sigfarma.sigfarma_api.modules.user.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Tipo_rol")
@Data
public class TypeRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(length = 255)
    private String descripcion;
}
