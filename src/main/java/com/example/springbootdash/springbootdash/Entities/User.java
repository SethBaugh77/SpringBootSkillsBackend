package com.example.springbootdash.springbootdash.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name="name")
    private String name;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    public Skill skill;


}
