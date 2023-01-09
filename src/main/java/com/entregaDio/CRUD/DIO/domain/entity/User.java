package com.entregaDio.CRUD.DIO.domain.entity;

import com.entregaDio.CRUD.DIO.rest.DTOs.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "TB_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    public static final Integer SerialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", length = 100)
    @NotNull(message = "{campo.user-name.obrigatorio}")
    @NotEmpty(message = "{campo.user-name.obrigatorio}")
    private String nome;

    @Email
    @Column(name = "email")
    @NotNull(message = "{campo.user-email.obrigatorio}")
    private String email;


    @NotNull(message = "{campo.user-senha.obrigatoria}")
    private String senha;

}
