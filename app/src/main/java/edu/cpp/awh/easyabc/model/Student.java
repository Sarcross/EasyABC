package edu.cpp.awh.easyabc.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "students")
public class Student {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String firstName;
    @DatabaseField
    private String lastName;
    @DatabaseField
    private String teacherName;
    @DatabaseField
    private String parentName;
    @DatabaseField(dataType = DataType.DATE_TIME)
    private Date dateOfBirth;
    @DatabaseField
    private GradeLevel gradeLevel;
    @DatabaseField
    private String school;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
