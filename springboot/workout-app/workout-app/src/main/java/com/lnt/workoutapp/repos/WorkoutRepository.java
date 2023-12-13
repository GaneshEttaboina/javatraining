package com.lnt.workoutapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lnt.workoutapp.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{

    
} 
