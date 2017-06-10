package org.launchcode.cheesemvc.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by msroc on 6/5/2017.
 */
public class User {

    @NotNull
    @Size(min = 5, max = 15, message = "Usernames must be 5 to 15 characters in length")
    private String username;

    @Email(message = "Please enter a valid email address")
    private String email;

    @NotNull
    @Size(min = 6, message = "Password must be a minimum of 6 characters in length")
    private String password;

    public User(){}

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
