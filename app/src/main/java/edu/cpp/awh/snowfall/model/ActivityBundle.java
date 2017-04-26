package edu.cpp.awh.snowfall.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "activityBundle")
public class ActivityBundle {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private Student student;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private Observation observation;
    @DatabaseField
    private String topic;
    @DatabaseField
    private Date time;
    @DatabaseField(dataType = DataType.DATE)
    private Activity activity;
    @DatabaseField
    private Antecedent antecedent;
    @DatabaseField
    private Behavior behavior;
    @DatabaseField
    private Consequence consequence;

    public enum Activity {
        Large_Group_Desk,
        Large_Group_Carpet,
        Small_Group,
        Centers,
        Independent_Work,
        Unstructured_Time
    }

    public enum Antecedent {
        Given_Instruction,
        Alone,
        Peer_Provoke,
        Engaged_In_Preferred_Activity,
        Preferred_Activity_Removed,
        Transition,
        Sensory_Conflict
    }

    public enum Behavior {
        Talking_Out,
        Off_Task,
        Physical_Aggression,
        Verbal_Aggression,
        Elopement,
        Tantrum,
        Theft,
        Harassment,
        Property_Damage,
        Crawling_On_Floor,
        Wandering_Room,
        Eating_NonFood_Items,
        Noncompliance
    }

    public enum Consequence {
        Adult_Attention,
        Peer_Attention,
        Got_Preferred_Activity_Or_Item,
        Sensory_Needs_Met,
        Ignored,
        Avoided_Task_Or_Activity,
        Required_To_Continue,
        Other
    }

    public ActivityBundle() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Antecedent getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(Antecedent antecedent) {
        this.antecedent = antecedent;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public Consequence getConsequence() {
        return consequence;
    }

    public void setConsequence(Consequence consequence) {
        this.consequence = consequence;
    }
}