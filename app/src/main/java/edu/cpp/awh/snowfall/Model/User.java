package edu.cpp.awh.snowfall.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "users")
public class User {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String password;

    public User() {
        this.name = "";
        this.password = "";
    }

    public User(String n, String p) {
        this.name = n;
        this.password = p;
    }

    public User withUsername(String us) {
        this.name = us;
        return this;
    }

    public User withPassword(String p) {
        this.password = p;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
