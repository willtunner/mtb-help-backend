package com.helpdesk.mtb.help_mtb.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name = "users")
@Data
@AllArgsConstructor
public class User extends Common {

    private String name;
    private String phone;
    private String email;
    private String password;
    private String connection;
    public User() {
    }
}
