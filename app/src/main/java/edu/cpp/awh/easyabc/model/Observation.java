package edu.cpp.awh.easyabc.model;

import java.util.ArrayList;
import java.util.Date;

public class Observation {
    private ArrayList<ActivityBundle> activityBundleList;
    private String location;
    private String notes;
    private Date observationStart;
    private Date observationEnd;

    public Observation() {
        activityBundleList = new ArrayList<>();
        observationStart = new Date();
        observationEnd = new Date();
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

    public Date getObservationEnd() {
        return observationEnd;
    }

    public void setObservationEnd(Date observationEnd) {
        this.observationEnd = observationEnd;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Observation withLocation(String loc) {
        this.location = loc;
        return this;
    }

    public Observation withObservationStart(Date d) {
        this.observationStart = d;
        return this;
    }

    public Observation withObservationEnd(Date d) {
        this.observationEnd = d;
        return this;
    }
}
