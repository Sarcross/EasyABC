package edu.cpp.awh.easyabc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private String firstName;
    private String lastName;
    private String teacherName;
    private String parentName;
    private Date dateOfBirth;
    private GradeLevel gradeLevel;
    private String school;

    private ArrayList<Observation> observationList;

    public enum GradeLevel
    {
        TK,
        K,
        G1,
        G2,
        G3,
        G4,
        G5,
        G6,
        G7,
        G8,
        G9,
        G10,
        G11,
        G12
    }

    public Student() {
        observationList = new ArrayList<>();
    }

    public Student withFirstName(String fn) {
        this.firstName = fn;
        return this;
    }

    public Student withLastName(String ln) {
        this.lastName = ln;
        return this;
    }

    public Student withDOB(Date date) {
        dateOfBirth = date;
        return this;
    }

    public Student withGradeLevel(GradeLevel gl) {
        this.gradeLevel = gl;
        return this;
    }

    public Student withSchool(String sch) {
        this.school = sch;
        return this;
    }

    public Student withTeacher(String t) {
        this.teacherName = t;
        return this;
    }

    public Student withParent(String p) {
        this.parentName = p;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public ArrayList<Observation> getObservationList() {
        return observationList;
    }

    public void setObservationList(ArrayList<Observation> observationList) {
        this.observationList = observationList;
    }

    public static GradeLevel gradeLevelFromString(String input) {
        switch(input)
        {
            default:
            case "TK":
                return GradeLevel.TK;
            case "K":
                return GradeLevel.K;
            case "Grade 1":
                return GradeLevel.G1;
            case "Grade 2":
                return GradeLevel.G2;
            case "Grade 3":
                return GradeLevel.G3;
            case "Grade 4":
                return GradeLevel.G4;
            case "Grade 5":
                return GradeLevel.G5;
            case "Grade 6":
                return GradeLevel.G6;
            case "Grade 7":
                return GradeLevel.G7;
            case "Grade 8":
                return GradeLevel.G8;
            case "Grade 9":
                return GradeLevel.G9;
            case "Grade 10":
                return GradeLevel.G10;
            case "Grade 11":
                return GradeLevel.G11;
            case "Grade 12":
                return GradeLevel.G12;

        }
    }

    public String getGradeLevelString() {
        switch(gradeLevel)
        {
            case TK:
                return "TK";
            case K:
                return "K";
            case G1:
                return "1";
            case G2:
                return "2";
            case G3:
                return "3";
            case G4:
                return "4";
            case G5:
                return "5";
            case G6:
                return "6";
            case G7:
                return "7";
            case G8:
                return "8";
            case G9:
                return "9";
            case G10:
                return "10";
            case G11:
                return "11";
            case G12:
                return "12";
        }
        return "Error - Grade Not Found";
    }
}
