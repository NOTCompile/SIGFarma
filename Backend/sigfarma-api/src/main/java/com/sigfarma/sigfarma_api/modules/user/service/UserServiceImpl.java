package com.sigfarma.sigfarma_api.modules.user.service;

import com.sigfarma.sigfarma_api.modules.user.dao.TypeRoleDAO;
import com.sigfarma.sigfarma_api.modules.user.dao.UserDAO;
import com.sigfarma.sigfarma_api.modules.user.dto.UserDTO;
import com.sigfarma.sigfarma_api.modules.user.model.TypeRole;
import com.sigfarma.sigfarma_api.modules.user.model.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final TypeRoleDAO typeRoleDAO;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder, TypeRoleDAO typeRoleDAO) {
        this.userDAO = userDAO;
        this.typeRoleDAO = typeRoleDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User registerUser(UserDTO dto){
        // Validacion del correo SI EXISTE
        if (userDAO.findByCorreo(dto.getCorreo()).isPresent()){
            throw new IllegalArgumentException("El correo ya se encuentra registrado");
        }
        // Validacion del dni SI EXISTE
        if (userDAO.findByDni(dto.getDni()).isPresent()){
            throw new IllegalArgumentException("El dni ya se encuentra registrado");
        }
        // Validacion del TipoRol SI EXISTE - BD
        TypeRole tipoRol = typeRoleDAO.findById(dto.getTipoRolId())
                .orElseThrow(() -> new IllegalArgumentException("El Rol NO EXISTE"));

        User user = new User();
        user.setNombres(dto.getNombres());
        user.setApellidos(dto.getApellidos());
        user.setDni(dto.getDni());
        user.setCelular(dto.getCelular());
        user.setCorreo(dto.getCorreo());
        user.setDireccion(dto.getDireccion());

        // Se aplica el HASH a la contraseña
        String contrasenia = passwordEncoder.encode(dto.getContrasenia());
        user.setContrasenia(contrasenia);

        user.setTipoRol(tipoRol);
        return userDAO.save(user);
    }
}
