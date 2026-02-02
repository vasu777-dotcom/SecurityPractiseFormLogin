package com.example.SecurityPractise.model;

import lombok.Data;

@Data
public class ErrorDto {

    private String code;
    private String path;
    private String message;
}
