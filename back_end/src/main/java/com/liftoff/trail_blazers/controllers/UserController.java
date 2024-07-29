package com.liftoff.trail_blazers.controllers;


import com.liftoff.trail_blazers.data.UserRepository;
import com.liftoff.trail_blazers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile/{id}")
    public User displayProfile(@PathVariable int id){
        return userRepository.findById(id);
    }

}
