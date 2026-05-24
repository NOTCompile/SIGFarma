package com.sigfarma.sigfarma_api.modules.user.dao;

import com.sigfarma.sigfarma_api.modules.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    Optional<User> findByCorreo(String correo);
    Optional<User> findByDni(String dni);
}
