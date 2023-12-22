package com.example.workoutApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workoutApplication.entities.Workouts;

public interface WorkoutsRepository  extends JpaRepository<Workouts, Integer>{

}
