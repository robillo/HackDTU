package com.appbusters.robinkamboj.hackdtu.classmodels;

/**
 * Created by junejaspc on 2/11/2017.
 */

public class Users {
  public String email,username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Users(String email, String username) {

        this.email = email;
        this.username = username;
    }
}
