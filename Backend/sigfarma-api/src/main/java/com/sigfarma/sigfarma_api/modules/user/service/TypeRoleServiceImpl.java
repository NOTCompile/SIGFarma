package com.sigfarma.sigfarma_api.modules.user.service;

import com.sigfarma.sigfarma_api.modules.user.dao.TypeRoleDAO;
import com.sigfarma.sigfarma_api.modules.user.dto.TypeRoleDTO;
import com.sigfarma.sigfarma_api.modules.user.model.TypeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeRoleServiceImpl implements TypeRoleService {
    @Autowired
    private TypeRoleDAO typeRoleDAO;

    @Override
    public List<TypeRoleDTO> listarTodos(){
        return typeRoleDAO.findAll().stream().map(rol -> {
            TypeRoleDTO dto = new TypeRoleDTO();
            dto.setId(rol.getId());
            dto.setNombre(rol.getNombre());
            dto.setDescripcion(rol.getDescripcion());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public TypeRoleDTO buscarPorId(Long id) {
        TypeRole role = typeRoleDAO.findById(id).
                orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        TypeRoleDTO dto = new TypeRoleDTO();
        dto.setId(role.getId());
        dto.setNombre(role.getNombre());
        return dto;
    }

    @Override
    public TypeRoleDTO guardarRol(TypeRoleDTO dto) {
        TypeRole role = new TypeRole();
        role.setNombre(dto.getNombre());
        role.setDescripcion(dto.getDescripcion());
        TypeRole roleSave = typeRoleDAO.save(role);
        dto.setId(roleSave.getId());
        return dto;
    }
}
