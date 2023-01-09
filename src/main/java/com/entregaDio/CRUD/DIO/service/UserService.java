package com.entregaDio.CRUD.DIO.service;

import com.entregaDio.CRUD.DIO.domain.entity.User;
import com.entregaDio.CRUD.DIO.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAll(){
        return userRepository.findAll();
    }


    public User getById(Integer id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não encontrado"));
        return user;
    }


    @Transactional
    public User salvar (User user){
      return  userRepository.save(user);
    }

    public User delete(Integer id){
        return userRepository.findById(id).map((existe)->{
            userRepository.delete(existe);
            return existe;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado"));
    }


    public User atualizar(Integer id, User user){
        return userRepository.findById(id).map((existe)->{
            user.setId(existe.getId());
            userRepository.save(user);
            return existe;
        }).orElseThrow(()->{
          return  new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        });
    }


}
