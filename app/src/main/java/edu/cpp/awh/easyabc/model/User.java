package edu.cpp.awh.easyabc.model;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private ArrayList<Student> studentList;

    public User() {
        this.name = "";
        this.password = "";
        studentList = new ArrayList<>();
    }

    public User(String n, String p) {
        this();
        this.name = n;
        this.password = p;
    }

    public User withUsername(String us) {
        this.name = us;
        return this;
    }

    public User withPassword(String p) {
        this.password = p;
        return this;
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

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
