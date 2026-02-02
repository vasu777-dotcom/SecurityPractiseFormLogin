package com.example.SecurityPractiseFormLogin.exception;

public class InvalidUserException extends RuntimeException{

    public InvalidUserException(String message){
        super(message);
    }
}
