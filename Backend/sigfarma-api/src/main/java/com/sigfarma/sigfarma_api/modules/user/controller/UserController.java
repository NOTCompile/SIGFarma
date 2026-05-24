package com.sigfarma.sigfarma_api.modules.user.controller;

import com.sigfarma.sigfarma_api.modules.user.dto.UserDTO;
import com.sigfarma.sigfarma_api.modules.user.model.User;
import com.sigfarma.sigfarma_api.modules.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            User newUser = userService.registerUser(userDTO);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
