package org.launchcode.cheesemvc.models;

/**
 * Created by msroc on 6/5/2017.
 */
public class User {
    String username;
    String email;
    String password;

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
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
