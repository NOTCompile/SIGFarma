package com.sigfarma.sigfarma_api.modules.user.dao;

import com.sigfarma.sigfarma_api.modules.user.model.TypeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRoleDAO extends JpaRepository<TypeRole, Long> {
}
