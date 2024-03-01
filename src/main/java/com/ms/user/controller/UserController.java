package com.ms.user.controller;

import com.ms.user.dto.UserCreateDTO;
import com.ms.user.dto.UserResponseDTO;
import com.ms.user.dto.UserUpdateDTO;
import com.ms.user.handler.ErrorMessage;
import com.ms.user.model.UserModel;
import com.ms.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/v1/users")
    @Operation(
            summary = "Create User",
            description = "Create user",
            tags = {"users"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDTO.class))),
                    @ApiResponse(responseCode = "422", description = "Unprocessable Entity - The request contains invalid parameters",
                            content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ErrorMessage.class))),
            }
    )
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserCreateDTO userCreateDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @GetMapping("/v1/users/{id}")
    @Operation(
                    summary = "Find User By id",
                    description = "Find User By id",
                    tags = {"users"},
                    responses = {
                            @ApiResponse(
                                    description = "Success",
                                    responseCode = "200",
                                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDTO.class))),
                            @ApiResponse(responseCode = "422", description = "Unprocessable Entity - The request contains invalid parameters",
                                    content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ErrorMessage.class))),
                            @ApiResponse(responseCode = "404", description = "Product not found",
                                    content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ErrorMessage.class))),
                            @ApiResponse(responseCode = "400", description = "Bad Request - The request is poorly formatted",
                                    content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ErrorMessage.class))),
                    }

    )
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id) {
        UserResponseDTO userResponseDTO = userService.getUserById(id);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("/v1/users/{id}")
    @Operation(
            summary = "Update User",
            description = "Update user details",
            tags = {"users"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content
                    )
            }
    )
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO updatedUserDto) {
        UserModel updatedUser = userService.updateUser(id, updatedUserDto);
        return ResponseEntity.ok(updatedUser);
    }




}
