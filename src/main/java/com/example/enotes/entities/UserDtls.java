package com.example.enotes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Users")
public class UserDtls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID", unique = true, nullable = false)
    private int id;
    @Column(name = "Full_Name", nullable = false)
    private String fullName;
    @Column(name = "E-Mail", nullable = false)
    private String email;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "About")
    private String about;
    private String role;
}
