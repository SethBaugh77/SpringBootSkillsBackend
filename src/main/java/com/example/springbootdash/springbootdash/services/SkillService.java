package com.example.springbootdash.springbootdash.services;

import com.example.springbootdash.springbootdash.Entities.Skill;
import com.example.springbootdash.springbootdash.Entities.User;
import com.example.springbootdash.springbootdash.Exceptions.UserNotFoundException;
import com.example.springbootdash.springbootdash.repositories.SkillRepository;
import com.example.springbootdash.springbootdash.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    private SkillRepository skillRepository;
    private UserService userService;
    UserRepository userRepository;

    public SkillService(SkillRepository skillRepository, UserService userService, UserRepository userRepository) {
        this.skillRepository = skillRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    @Transactional
    public void insertSkill(Skill skill) {

        Optional<User> user = userRepository.findById(skill.getUserId());
        if (user.isEmpty()) {
            throw new UserNotFoundException("User does not exist");
        }
        skill.setUserId(0);
        skill.setUser(user.get());
        skillRepository.save(skill);
    }

}
//the above needs to link based off the associated user object.