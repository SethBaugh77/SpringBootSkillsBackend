package com.example.springbootdash.springbootdash.repositories;

import com.example.springbootdash.springbootdash.Entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
