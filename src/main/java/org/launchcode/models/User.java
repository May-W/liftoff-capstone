package org.launchcode.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "email")
    @Email(message = "Please provide a valid Email")
    @NotNull(message = "Please provide a valid Email")
    private String email;

    @Column(name = "password")
    @NotNull(message = "Please enter a password. Password must not be blank.")
    @Size(min = 1, message = "Please enter a password. Password must not be blank.")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
