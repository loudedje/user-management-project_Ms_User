package com.ms.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserCreateDTO {

        @NotBlank(message = "O campo 'firstName' é obrigatório.")
        @Size(min = 3, message = "O campo 'firstName' precisa ter no mínimo 3 caracteres.")
        private String firstName;

        @NotBlank(message = "O campo 'lastName' é obrigatório.")
        @Size(min = 3, message = "O campo 'lastName' precisa ter no mínimo 3 caracteres.")
        private String lastName;

        @NotBlank(message = "O campo 'cpf' é obrigatório.")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O campo 'cpf' precisa seguir o padrão 'xxx.xxx.xxx-xx'.")
        private String cpf;

        @NotBlank(message = "O campo 'birthdate' é obrigatório.")
        @JsonFormat(pattern = "yyyy/MM/dd")
        private String birthdate;

        @NotBlank(message = "O campo 'email' é obrigatório.")
        @Email(message = "O campo 'email' precisa estar no formato de um email válido.")
        private String email;

        @NotBlank(message = "O campo 'cep' é obrigatório.")
        private String cep;

        @NotBlank(message = "O campo 'password' é obrigatório.")
        @Size(min = 6, message = "O campo 'password' precisa ter no mínimo 6 caracteres.")
        private String password;

        @NotNull(message = "O campo 'active' é obrigatório.")
        private Boolean active;




}


