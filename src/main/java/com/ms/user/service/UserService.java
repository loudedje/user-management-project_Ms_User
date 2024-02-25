package com.ms.user.service;

import com.ms.user.config.UserNotFoundException;
import com.ms.user.dto.UserCreateDTO;
import com.ms.user.dto.UserResponseDTO;
import com.ms.user.dto.UserUpdateDTO;
import com.ms.user.mapper.UserMapper;
import com.ms.user.model.UserModel;
import com.ms.user.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

     private  final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public  UserResponseDTO createUser(UserCreateDTO userDto) {
        UserModel userModel = UserMapper.toUser(userDto);
        userModel = userRepository.save(userModel);

        return UserMapper.toUserResponseDTO(userModel);
    }

    public UserResponseDTO getUserById(Long id) {
        UserModel userModel = userRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario não encontrado"));
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

        return userRepository.save(existingUser);
    }



}

