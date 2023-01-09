package com.entregaDio.CRUD.DIO.rest.controller;

import com.entregaDio.CRUD.DIO.exception.RegraException;
import com.entregaDio.CRUD.DIO.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvicer {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RegraException.class)
    public ApiErrors handleRegraDeNegociosExecption(RegraException ex){
        String messageErro = ex.getMessage();
        return new ApiErrors(messageErro);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErrors(errors);
    }
}
