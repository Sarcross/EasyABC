package edu.cpp.awh.easyabc.model;

import java.util.Date;

public class ActivityBundle {
    private String topic;
    private Date time;
    private Activity activity;
    private Antecedent antecedent;
    private Behavior behavior;
    private Consequence consequence;
    private String consequenceOption;

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

    public String getConsequenceOption() {
        return consequenceOption;
    }

    public void setConsequenceOption(String consequenceOption) {
        this.consequenceOption = consequenceOption;
    }

    public static Activity activityFromString(String input) {
        Activity activity;
        switch(input)
        {
            default:
            case "Large Group - Desk":
                activity = Activity.Large_Group_Desk;
                break;
            case "Large Group - Carpet":
                activity = Activity.Large_Group_Carpet;
                break;
            case "Small Group":
                activity = Activity.Small_Group;
                break;
            case "Centers":
                activity = Activity.Centers;
                break;
            case "Independent Work":
                activity = Activity.Independent_Work;
                break;
            case "Unstructured Time":
                activity = Activity.Unstructured_Time;
                break;
        }

        return activity;
    }

    public static Antecedent antecedentFromString(String input) {
        Antecedent antecedent;
        switch(input)
        {
            default:
            case "Given Instruction":
                antecedent = Antecedent.Given_Instruction;
                break;
            case "Alone (No Attention)":
                antecedent = Antecedent.Alone;
                break;
            case "Peer Provoke":
                antecedent = Antecedent.Peer_Provoke;
                break;
            case "Engaged in Preferred Activity":
                antecedent = Antecedent.Engaged_In_Preferred_Activity;
                break;
            case "Preferred Activity Removed":
                antecedent = Antecedent.Preferred_Activity_Removed;
                break;
            case "Transition":
                antecedent = Antecedent.Transition;
                break;
            case "Sensor Conflict":
                antecedent = Antecedent.Sensory_Conflict;
                break;
        }

        return antecedent;
    }

    public static Behavior behaviorFromString(String input) {
        Behavior behavior;
        switch(input)
        {
            default:
            case "Talking Out":
                behavior = Behavior.Talking_Out;
                break;
            case "Off Task":
                behavior = Behavior.Off_Task;
                break;
            case "Physical Aggression":
                behavior = Behavior.Physical_Aggression;
                break;
            case "Verbal Aggression":
                behavior = Behavior.Verbal_Aggression;
                break;
            case "Elopement":
                behavior = Behavior.Elopement;
                break;
            case "Tantrum / Meltdown":
                behavior = Behavior.Tantrum;
                break;
            case "Theft":
                behavior = Behavior.Theft;
                break;
            case "Harassment / Teasing / Bullying":
                behavior = Behavior.Harassment;
                break;
            case "Property Damage":
                behavior = Behavior.Property_Damage;
                break;
            case "Crawling on the Floor":
                behavior = Behavior.Crawling_On_Floor;
                break;
            case "Wandering Room":
                behavior = Behavior.Wandering_Room;
                break;
            case "Eating Non-Food Items":
                behavior = Behavior.Eating_NonFood_Items;
                break;
            case "Noncompliance":
                behavior = Behavior.Noncompliance;
                break;
        }

        return behavior;
    }

    public static Consequence consequenceFromString(String input) {
        Consequence consequence;
        switch(input)
        {
            default:
            case "Adult Attention":
                consequence = Consequence.Adult_Attention;
                break;
            case "Peer Attention":
                consequence = Consequence.Peer_Attention;
                break;
            case "Got Preferred Activity / Item":
                consequence = Consequence.Got_Preferred_Activity_Or_Item;
                break;
            case "Sensory Needs Met":
                consequence = Consequence.Sensory_Needs_Met;
                break;
            case "Ignored":
                consequence = Consequence.Ignored;
                break;
            case "Avoided Task / Activity":
                consequence = Consequence.Avoided_Task_Or_Activity;
                break;
            case "Required to Continue":
                consequence = Consequence.Required_To_Continue;
                break;
            case "Other":
                consequence = Consequence.Other;
                break;
        }

        return consequence;
    }
}