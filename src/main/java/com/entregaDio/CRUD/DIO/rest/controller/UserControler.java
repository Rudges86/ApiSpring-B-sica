package com.entregaDio.CRUD.DIO.rest.controller;

import com.entregaDio.CRUD.DIO.domain.entity.User;
import com.entregaDio.CRUD.DIO.rest.DTOs.UserDTO;
import com.entregaDio.CRUD.DIO.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")

public class UserControler {
    @Autowired
    private UserService userService;

    @GetMapping

    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
    }


    @PostMapping

    public ResponseEntity<User> save(@RequestBody @Valid UserDTO userDTO){
        User user = new User();
        user.setNome(userDTO.getNome());
        user.setEmail(userDTO.getEmail());
        user.setSenha(userDTO.getSenha());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userService.salvar(user));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.delete(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable Integer id, @RequestBody @Valid User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.atualizar(id,user));
    }
}
