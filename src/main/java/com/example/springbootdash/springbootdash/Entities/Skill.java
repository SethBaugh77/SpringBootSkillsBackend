package com.example.springbootdash.springbootdash.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "skills")
@Setter
@Getter
public class Skill {


    @Id
    @Column(name = "user_id")
    private int userId;
    @Column(name = "guitar")
    private int guitar;
    @Column(name = "rocketleague")
    private int rocketleague;

    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;
    //need to populate everything with a value here. and the foregin key is populated
    //based off the user object. Bc the foreign key has to be apart of the User table.
    //So, populate the User with the user it is associated with.
}
