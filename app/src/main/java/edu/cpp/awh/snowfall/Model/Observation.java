package edu.cpp.awh.snowfall.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Date;


@DatabaseTable(tableName = "observations")
public class Observation {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private Student student;
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
}
