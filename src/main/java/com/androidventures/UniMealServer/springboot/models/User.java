package com.androidventures.UniMealServer.springboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "userauth")
public class User {
    @Id
    private String username;
    private String password;
    private String role;


}
