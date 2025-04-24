package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String email;


    @Enumerated(EnumType.STRING)
    private Role role;

}

enum Role{
    ADMIN, EDITOR, VIEWER
}
