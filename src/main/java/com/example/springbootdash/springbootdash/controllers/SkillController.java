package com.example.springbootdash.springbootdash.controllers;

import com.example.springbootdash.springbootdash.Entities.Skill;
import com.example.springbootdash.springbootdash.Entities.User;
import com.example.springbootdash.springbootdash.repositories.UserRepository;
import com.example.springbootdash.springbootdash.services.SkillService;
import com.example.springbootdash.springbootdash.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.net.URI;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class SkillController {

    private SkillService skillService;
    private UserService userService;

    public SkillController(SkillService skillService, UserService userService) {
        this.skillService = skillService;
        this.userService = userService;
    }


    @GetMapping("/skills")
    public String getSkills(){

        return "Number of skills: " + skillService.getSkills().size();
    }

    @PostMapping("skills")
    public ResponseEntity<String> addSkill(@RequestBody Skill skill){
        skillService.insertSkill(skill);

        URI location = URI.create("/skills/" + skill.getUserId());

        return ResponseEntity.created(location).body("Skill created at " + location.toString());
    }




}
