package com.liftoff.trail_blazers.controllers;


import com.liftoff.trail_blazers.data.UserRepository;
import com.liftoff.trail_blazers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile/{id}")
    public Optional<User> displayProfile(@PathVariable int id){
        return userRepository.findById(id);
    }

    @PutMapping("/login/{id}")
    public User logIn(@PathVariable int id, @RequestBody User loginUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFname(loginUser.getFname());
                    user.setEmail(loginUser.getEmail());
                    user.setPassword(loginUser.getPassword());
                    user.setStatus(loginUser.getStatus());

                    return userRepository.save(user);
                }).orElseThrow(()-> new Error("user not found"));
    }

}
