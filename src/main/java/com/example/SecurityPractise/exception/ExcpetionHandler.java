package com.example.SecurityPractise.exception;

import com.example.SecurityPractise.model.ErrorDto;
import com.example.SecurityPractise.model.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExcpetionHandler {

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ResponseDto<?>> handleException(InvalidUserException exception){
        ResponseDto<?> dto = new ResponseDto<>();
        dto.setBody(null);
        dto.setStatus("ERROR");
        ErrorDto error = new ErrorDto();
        error.setCode("404");
        error.setPath("/validate");
        error.setMessage(exception.getMessage());
        dto.setErrors(List.of(error));
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
