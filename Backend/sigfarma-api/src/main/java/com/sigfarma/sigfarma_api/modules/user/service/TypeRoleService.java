package com.sigfarma.sigfarma_api.modules.user.service;

import com.sigfarma.sigfarma_api.modules.user.dto.TypeRoleDTO;
import java.util.List;

public interface TypeRoleService {
    List<TypeRoleDTO> listarTodos();
    TypeRoleDTO buscarPorId(Long id);
    TypeRoleDTO guardarRol(TypeRoleDTO tipoRolDTO);

}
