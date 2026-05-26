package com.sigfarma.sigfarma_api.modules.user.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String nombres;
    private String apellidos;
    private Number dni;
    private Number celular;
    private String correo;
    private String direccion;
    private String contrasenia;
    private Long tipoRolId;     // Solo se envia el ID del rol
}