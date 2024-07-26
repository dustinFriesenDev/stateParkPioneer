package com.liftoff.trail_blazers.model;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table (name = "name")
public class Name extends AbstractEntity{

    @NotNull
    private String name;
    @NotNull
    private String email;

    private String password;

    @OneToMany(mappedBy="name")
    private Set<Trips> trips;

    private String status;

    public Name(String name, String email, String password, String status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public Name() {
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
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

    public Set<Trips> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trips> trips) {
        this.trips = trips;
    }
}
