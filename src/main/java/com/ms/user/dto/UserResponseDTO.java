package com.ms.user.dto;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String cpf;
    private String birthdate;
    private String email;
    private String cep;
    private boolean active;

}
