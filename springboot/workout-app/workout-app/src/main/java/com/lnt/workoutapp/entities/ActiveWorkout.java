package com.lnt.workoutapp.entities;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ActiveWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    LocalTime startTime;
    LocalTime endTime;

    @OneToOne
    Workout workout;
    
    @OneToOne
    User user;
    
}

