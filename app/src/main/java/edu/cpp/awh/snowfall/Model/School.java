package edu.cpp.awh.snowfall.Model;

import android.location.Address;

public class School {
    private String name;
    private Address address;

    public School() {
        this.name = "";
        this.address = null;
    }

    public School withName(String n) {
        this.name = n;
        return this;
    }

    public School withAddress(Address a) {
        this.address = a;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
