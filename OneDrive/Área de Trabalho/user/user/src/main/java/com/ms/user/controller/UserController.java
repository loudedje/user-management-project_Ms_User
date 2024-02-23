package com.ms.user.controller;

import com.ms.user.model.UserModel;
import com.ms.user.repositories.UserRepository;
import com.ms.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserModel userModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

}
