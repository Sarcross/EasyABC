package edu.cpp.awh.snowfall.Model;

public class User {
    private String name;
    private String password;

    public User() {
        this.name = "";
        this.password = "";
    }

    public User(String n, String p) {
        this.name = n;
        this.password = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
