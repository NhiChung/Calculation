package com.NhiChung.Selenium.restAssured44.model;

public class Authen {
    private String email;
    private String password;

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

    public Authen(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public Authen(String email) {
        this.email = email;
    }

    public Authen() {
    }
}
