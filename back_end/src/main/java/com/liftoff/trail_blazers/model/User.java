package com.liftoff.trail_blazers.model;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "user")
public class User extends AbstractEntity{

    @NotNull
    private String fname;

    @NotNull
    private String email;

    private String password;

    private String status;

    @OneToMany(mappedBy="user", orphanRemoval = true)
    @JsonBackReference
    private List<Trips> trips = new ArrayList<>();

    public User(String fname, String email, String password, String status) {
        this.fname = fname;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public User() {}

    public @NotNull String getFname() {
        return fname;
    }

    public void setFname(@NotNull String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Trips> getTrips() {
        return trips;
    }
}
