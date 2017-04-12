package edu.cpp.awh.snowfall.Model;

public class Behavior {
    private Antecedent antecedent;
    private StudentBehavior studentBehavior;
    private Consequence consequence;

    public Behavior() {

    }

    public Antecedent getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(Antecedent antecedent) {
        this.antecedent = antecedent;
    }

    public StudentBehavior getStudentBehavior() {
        return studentBehavior;
    }

    public void setStudentBehavior(StudentBehavior studentBehavior) {
        this.studentBehavior = studentBehavior;
    }

    public Consequence getConsequence() {
        return consequence;
    }

    public void setConsequence(Consequence consequence) {
        this.consequence = consequence;
    }

    public enum Antecedent {

    }

    public enum StudentBehavior {

    }

    public enum Consequence {

    }
}

