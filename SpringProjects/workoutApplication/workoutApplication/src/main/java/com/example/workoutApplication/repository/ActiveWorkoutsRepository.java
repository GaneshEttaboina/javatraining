package com.example.workoutApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workoutApplication.entities.ActiveWorkouts;

public interface ActiveWorkoutsRepository extends JpaRepository<ActiveWorkouts,Integer> {

}
