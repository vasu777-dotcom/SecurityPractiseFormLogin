package com.example.SecurityPractise.model;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
public class ResponseDto<T> {
    private String status;
    private T body;
    private List<ErrorDto> errors;
}
