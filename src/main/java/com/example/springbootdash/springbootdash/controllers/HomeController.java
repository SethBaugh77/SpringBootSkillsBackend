package com.example.springbootdash.springbootdash.controllers;


import com.example.springbootdash.springbootdash.Entities.User;
import com.example.springbootdash.springbootdash.Exceptions.DuplicateEntryException;
import com.example.springbootdash.springbootdash.services.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(){

         userService.getUsers().forEach(user -> System.out.println(user.getSkill()));
         return "Hello World";
    }

    @PostMapping("/users")
    public ResponseEntity<String> postUser (@RequestBody User user){
        userService.insertUser(user);
        URI location = URI.create("/users/" + user.getUserId());
        return ResponseEntity.created(location).body("User created at " + location.toString());
    }


}
