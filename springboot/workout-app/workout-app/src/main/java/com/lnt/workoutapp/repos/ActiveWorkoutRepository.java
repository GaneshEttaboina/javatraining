package com.lnt.workoutapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lnt.workoutapp.entities.ActiveWorkout;

public interface ActiveWorkoutRepository extends JpaRepository<ActiveWorkout, Integer> {
    
}
