package com.lnt.workoutapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.workoutapp.entities.Workout;
import com.lnt.workoutapp.entities.Category;
import com.lnt.workoutapp.repos.CategoryRepository;
import com.lnt.workoutapp.repos.WorkoutRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/workouts")
@Slf4j
public class WorkoutController {
    @Autowired
    WorkoutRepository workoutRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createWorkout(@RequestBody Workout workout){
        // if category id is present .. load that object
        int categoryId = workout.getCategory().getId();

        log.warn("Category is : " + categoryId);
        System.out.println("Category is : " + categoryId);

        if(categoryId > 0){
           Optional<Category> categoryFound =  categoryRepository.findById(categoryId);
           if(categoryFound.isPresent()){
                workout.setCategory(categoryFound.get());
           }
        }
        
        
        workoutRepository.save(workout);
    }}