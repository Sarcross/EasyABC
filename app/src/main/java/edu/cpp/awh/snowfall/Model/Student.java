package edu.cpp.awh.snowfall.Model;

public class Student {
    private String firstName;
    private char middleInitial;
    private String lastName;

    private DateTime dateOfBirth;

    public Student() {
        dateOfBirth = new DateTime();
    }

    public Student withFirstName(String fn) {
        this.firstName = fn;
        return this;
    }

    public Student withLastName(String ln) {
        this.lastName = ln;
        return this;
    }

    public Student withMiddleInitial(String mi) {
        this.middleInitial = mi.charAt(0);
        return this;
    }

    public Student withMiddleInitial(char mi) {
        this.middleInitial = mi;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
