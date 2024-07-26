package com.liftoff.trail_blazers.controllers;


import com.liftoff.trail_blazers.data.NameRepository;
import com.liftoff.trail_blazers.data.PlantsRepository;
import com.liftoff.trail_blazers.model.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class NameController {

    @Autowired
    private NameRepository nameRepository;

    @GetMapping("/profile")
    public List<Name> displayProfile(@PathVariable Name name){
        return nameRepository.findByName(name);
    }

}
