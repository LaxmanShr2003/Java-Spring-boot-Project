package com.example.demo.models;

import jakarta.persistence.*;


@Entity
public class User {

    @Id
    private String id;
    private String userName;
    private String email;
    private String password;
    

    

}
