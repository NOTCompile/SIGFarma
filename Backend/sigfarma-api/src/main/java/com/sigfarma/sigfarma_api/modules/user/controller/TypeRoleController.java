package com.sigfarma.sigfarma_api.modules.user.controller;

import com.sigfarma.sigfarma_api.modules.user.dto.TypeRoleDTO;
import com.sigfarma.sigfarma_api.modules.user.service.TypeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typerole")
@CrossOrigin(origins = "*")
public class TypeRoleController {
    @Autowired
    private TypeRoleService typeRoleService;

    // GET: http://localhost:8080/api/typerole
    @GetMapping
    public ResponseEntity<List<TypeRoleDTO>> listarRoles() {
        return ResponseEntity.ok(typeRoleService.listarTodos());
    }

    // GET: http://localhost:8080/api/typerole/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TypeRoleDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(typeRoleService.buscarPorId(id));
    }

    // POST: http://localhost:8080/api/typerole
    @PostMapping
    public ResponseEntity<TypeRoleDTO> crearRol(@RequestBody TypeRoleDTO typeRoleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(typeRoleService.guardarRol(typeRoleDTO));
    }


}
