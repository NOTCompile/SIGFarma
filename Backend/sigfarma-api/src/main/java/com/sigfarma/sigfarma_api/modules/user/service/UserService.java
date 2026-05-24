package com.sigfarma.sigfarma_api.modules.user.service;

import com.sigfarma.sigfarma_api.modules.user.dto.UserDTO;
import com.sigfarma.sigfarma_api.modules.user.model.User;

public interface UserService {
    User registerUser(UserDTO dto);
}
