package com.example.SecurityPractise.controller;

import com.example.SecurityPractise.model.User;
import com.example.SecurityPractise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyMvcController {

    @Autowired
    private UserService userService;

    @GetMapping({"/home","/"})
    public String showHome() {
        return "Home";
    }

    @GetMapping("/hello")
    public String showHello() {
        return "Hello";
    }

    @GetMapping("/admin")
    public String showAdmin() {
        return "Admin";
    }

    @GetMapping("/customer")
    public String showCustomer() {
        return "Customer";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "Login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "Register";
    }

    @GetMapping("/denied")
    public String showDenied(){
        return "Denied";
    }

    @GetMapping("/logoutt")
    public String showLogout(){
        return "Logout";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "Login";
    }
}

