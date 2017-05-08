package edu.cpp.awh.easyabc.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Date;


@DatabaseTable(tableName = "observations")
public class Observation {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private Student student;
    @ForeignCollectionField(eager = true)
    private ArrayList<ActivityBundle> activityBundleList;
    @DatabaseField
    private String location;
    @DatabaseField(dataType = DataType.DATE)
    private Date observationStart;
    @DatabaseField(dataType = DataType.DATE)
    private Date observationEnd;

    public Observation() {

    }

    public ArrayList<ActivityBundle> getActivityBundleList() {
        return activityBundleList;
    }

    public void setActivityBundleList(ArrayList<ActivityBundle> activityBundleList) {
        this.activityBundleList = activityBundleList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getObservationStart() {
        return observationStart;
    }

    public void setObservationStart(Date observationStart) {
        this.observationStart = observationStart;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getObservationEnd() {
        return observationEnd;
    }

    public void setObservationEnd(Date observationEnd) {
        this.observationEnd = observationEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Observation withLocation(String loc) {
        this.location = loc;
        return this;
    }

    public Observation withObservationStart(Date d) {
        this.observationStart = d;
        return this;
    }

    public Observation withStudent(Student s) {
        this.student = s;
        return this;
    }

    public Observation withObservationEnd(Date d) {
        this.observationEnd = d;
        return this;
    }
}
