package com.liftoff.trail_blazers.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Trips extends AbstractEntity {

    private String tripName;
    private String location;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    private List<Plants> plants = new ArrayList<>();

    @ManyToMany
    private List<Fauna> fauna = new ArrayList<>();

    public Trips(String tripName, String location, Date date, String notes, User user, List<Plants> plants, List<Fauna> fauna) {
        this.tripName = tripName;
        this.location = location;
        this.date = date;
        this.notes = notes;
        this.user = user;
        this.plants = plants;
        this.fauna = fauna;
    }

    public Trips() {}

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Plants> getPlants() {return plants;}

    public void setPlants(List<Plants> plants) {
        this.plants = plants;
    }

    public List<Fauna> getFauna() {
        return fauna;
    }

    public void setFauna(List<Fauna> fauna) {
        this.fauna = fauna;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return tripName;
    }

}
