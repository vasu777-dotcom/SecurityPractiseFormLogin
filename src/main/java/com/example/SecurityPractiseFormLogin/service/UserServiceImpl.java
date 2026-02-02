package com.example.SecurityPractiseFormLogin.service;

import com.example.SecurityPractiseFormLogin.exception.InvalidUserException;
import com.example.SecurityPractiseFormLogin.model.User;
import com.example.SecurityPractiseFormLogin.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    public String registerUser(User user){
        String message;
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            message = "User is registered";
        }
        catch(Exception exception){
            message = "Issue with User Registration - "+user.getUsername();
            exception.printStackTrace();
        }

        return message;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new InvalidUserException("Username is NOT found in DB"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getRoles().stream().map(SimpleGrantedAuthority::new).toList());
    }
}
