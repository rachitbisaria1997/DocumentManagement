package com.example.demo.controller;

import com.example.demo.DTO.Login;
import com.example.demo.DTO.UserRegister;
import com.example.demo.security.JwtProvider;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegister userRegister){

        User user = userRepository.findByEmail(userRegister.getEmail());

        if(user != null){
            return ResponseEntity.badRequest().body("Email already exists");
        }

        User newUser = new User();
        newUser.setUsername(userRegister.getUsername());
        newUser.setPassword(userRegister.getPassword());
        newUser.setEmail(userRegister.getEmail());
        newUser.setRole(userRegister.getRole());

        userRepository.save(newUser);

        return ResponseEntity.ok("User is registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login){
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);

        return ResponseEntity.ok("User has been login successfully");

    }


}
