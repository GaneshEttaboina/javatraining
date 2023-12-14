package com.lnt.workoutapp.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;
    String description;
    int cbpm;

    @ManyToOne(cascade = CascadeType.ALL)
    Category category;



}
