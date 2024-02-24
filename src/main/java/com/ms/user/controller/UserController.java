package com.ms.user.controller;

import com.ms.user.dto.UserCreateDTO;
import com.ms.user.dto.UserResponseDTO;
import com.ms.user.dto.UserUpdateDTO;
import com.ms.user.model.UserModel;
import com.ms.user.repositories.UserRepository;
import com.ms.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/v1/users")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserCreateDTO userCreateDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }
    @GetMapping("/v1/users/{id}")
    public ResponseEntity<UserResponseDTO>getById(@PathVariable Long id){
        UserResponseDTO userResponseDTO = userService.getUserById(id);
        return ResponseEntity.ok(userResponseDTO);

    }
    @PutMapping("/v1/users/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO updatedUserDto) {
        UserModel updatedUser = userService.updateUser(id, updatedUserDto);
        return ResponseEntity.ok(updatedUser);
    }

}
