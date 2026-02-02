package com.example.SecurityPractiseFormLogin.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDto<T> {
    private String status;
    private T body;
    private List<ErrorDto> errors;
}
