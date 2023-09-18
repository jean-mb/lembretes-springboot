package com.uniamerica.lembretes.config;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
@RestControllerAdvice
public class GlobalErrorHandler {
    /**
     * Erros de Service
     * */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }

    /**
     * Erros do Hibernate Validator
     * */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String  handleValidationException(
            final MethodArgumentNotValidException methodArgumentNotValidException
    ){
        List<ObjectError> errors = methodArgumentNotValidException.getBindingResult().getAllErrors();
        FieldError firstError = (FieldError) errors.get(0);
        return firstError.getDefaultMessage();
    }

    /**
     * Erros de sintaxe no body
     * */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String handleJsonException(){
        return "Existem erros na sua solicitação!";
    }

}