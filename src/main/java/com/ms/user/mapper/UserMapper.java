package com.ms.user.mapper;
import com.ms.user.dto.UserCreateDTO;
import com.ms.user.dto.UserResponseDTO;
import com.ms.user.model.UserModel;
import org.modelmapper.ModelMapper;

public class UserMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserModel toUser(UserCreateDTO userCreateDTO) {
        return modelMapper.map(userCreateDTO, UserModel.class);
    }

    public static UserResponseDTO toUserResponseDTO(UserModel userModel) {
        return modelMapper.map(userModel, UserResponseDTO.class);
    }
}
