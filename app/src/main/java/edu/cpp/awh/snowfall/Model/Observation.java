package edu.cpp.awh.snowfall.Model;

import java.util.ArrayList;
import java.util.List;

public class Observation {
    private List<Behavior> behaviorList;
    private DateTime startTime;
    private DateTime endTime;
    private School location;

    public Observation() {
        behaviorList = new ArrayList<>();
        startTime = new DateTime();
        endTime = new DateTime();
        location = new School();
    }

    public List<Behavior> getBehaviorList() {
        return behaviorList;
    }

    public void setBehaviorList(List<Behavior> behaviorList) {
        this.behaviorList = behaviorList;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public School getLocation() {
        return location;
    }

    public void setLocation(School location) {
        this.location = location;
    }
}
