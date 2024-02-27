package com.ms.user.service;

import com.ms.user.config.UserNotFoundException;
import com.ms.user.dto.UserCreateDTO;
import com.ms.user.dto.UserResponseDTO;
import com.ms.user.dto.UserUpdateDTO;
import com.ms.user.exception.UsernameUniqueViolationException;
import com.ms.user.mapper.UserMapper;
import com.ms.user.model.UserModel;
import com.ms.user.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public UserResponseDTO createUser(UserCreateDTO userDto) {
        try {
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            UserModel userModel = UserMapper.toUser(userDto);
            userModel = userRepository.save(userModel);
            return UserMapper.toUserResponseDTO(userModel);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UsernameUniqueViolationException(String.format("Usuário com o CPF %s já está cadastrado", userDto.getCpf()));
        }
    }

    public UserResponseDTO getUserById(Long id) {
        UserModel userModel = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        return UserMapper.toUserResponseDTO(userModel);
    }

    @Transactional
    public UserModel updateUser(Long userId, UserUpdateDTO updatedUserDto) {
        UserModel existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado com o ID: " + userId));

        if (updatedUserDto.getEmail() != null) {
            existingUser.setEmail(updatedUserDto.getEmail());
        }

        if (updatedUserDto.getCep() != null) {
            existingUser.setCep(updatedUserDto.getCep());
        }

        if (updatedUserDto.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(updatedUserDto.getPassword()));
        }

        return userRepository.save(existingUser);
    }

    @Transactional(readOnly = true)
    public UserModel buscarPorEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(String.format("Usuário com o email '%s' não encontrado", email)));
    }

    @Transactional(readOnly = true)
    public UserModel buscarPorUserActive(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(String.format("Usuário com o email '%s' não encontrado", email)));
    }

}


