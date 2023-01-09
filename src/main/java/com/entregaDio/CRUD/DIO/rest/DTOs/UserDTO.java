package com.entregaDio.CRUD.DIO.rest.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDTO {
    @NotBlank
    @Size(max = 11)
    private String nome;
    @Email(message = "{campo.user-email.invalido}")
    private String email;
    @NotBlank
    private String senha;

}
