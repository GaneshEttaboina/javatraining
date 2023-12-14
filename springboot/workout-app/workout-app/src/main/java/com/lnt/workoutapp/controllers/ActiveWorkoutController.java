package com.lnt.workoutapp.controllers;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.workoutapp.entities.ActiveWorkout;
import com.lnt.workoutapp.repos.ActiveWorkoutRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1")
public class ActiveWorkoutController {

    @Autowired
    ActiveWorkoutRepository activeWorkoutRepository;


    @GetMapping("/activeworkouts")
    @ResponseStatus(HttpStatus.OK)
    public List<ActiveWorkout> getActiveWorkout() {
        return activeWorkoutRepository.findAll();
    }
    
    
    @PostMapping("/activeworkouts")
    @ResponseStatus(HttpStatus.CREATED)
    public void createActiveWorkout(@RequestBody ActiveWorkout activeWorkout){
        activeWorkout.setStartTime(LocalTime.now());
        activeWorkoutRepository.save(activeWorkout);

    }
}
