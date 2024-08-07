package com.liftoff.trail_blazers.controllers;

import com.liftoff.trail_blazers.data.TripsFPRepository;
import com.liftoff.trail_blazers.data.TripsRepository;
import com.liftoff.trail_blazers.model.Trips;
import com.liftoff.trail_blazers.model.dto.TripsFPDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/trips")
public class TripsController {

    @Autowired
    private TripsRepository tripsRepository;
    @Autowired
    private TripsFPRepository tripsFPRepository;

    @GetMapping("/all/{id}")
    public List<Trips> displayAllTrips(@PathVariable int id) {
        return tripsRepository.findByUserId(id);

    }

    @PostMapping("/add")
    public String addTrip(@RequestBody TripsFPDTO tripsFP){
        Trips trips = new Trips();
        trips.setDate(tripsFP.getDate());
        trips.setLocation(tripsFP.getLocation());
        trips.setTripName(tripsFP.getTripName());
        trips.setPlants(tripsFP.getPlants());
        trips.setNotes(tripsFP.getNotes());
        trips.setUser((tripsFP.getUser()));
        trips.setFauna(tripsFP.getFauna());
        tripsRepository.save(trips);
        return "redirect:/all/{id}";
    }

    @PutMapping("/update/{id}")
    public Trips updateTrip(@PathVariable int id, @RequestBody Trips newTrips) {
       return tripsRepository.findById(id)
        .map(trip -> {
            trip.setTripName(newTrips.getTripName());
            trip.setLocation(newTrips.getLocation());
            trip.setDate(newTrips.getDate());
            if(newTrips.getNotes().isEmpty()){
                trip.setNotes(null);
            } else {
                trip.setNotes(newTrips.getNotes());
            }
            trip.setPlants(newTrips.getPlants());
            trip.setFauna(newTrips.getFauna());

            return tripsRepository.save(trip);
        }).orElseThrow(()-> new Error("trip not found"));
    }

    @DeleteMapping("/delete/{id}")
    public String processDeleteTrip(@PathVariable int id){
        if (!tripsRepository.existsById(id)) {
            throw new Error("Trip not found.");
        }
        tripsRepository.deleteById(id);
        return "redirect:/all/{user_id}";
    }

}
