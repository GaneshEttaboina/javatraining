package com.example.workoutApplication.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workoutApplication.entities.Category;
import com.example.workoutApplication.entities.Workouts;
import com.example.workoutApplication.repository.CategoryRepsitory;
import com.example.workoutApplication.repository.WorkoutsRepository;

@RestController
@RequestMapping("/a/b")
public class WorkoutController {
	@Autowired
	CategoryRepsitory categoryRepsitory;
	@Autowired
	WorkoutsRepository workoutsRepository;
	@PostMapping("/p")
	public void createworkout(@RequestBody Workouts workouts) {
		int categoryId=workouts.getCategory().getId();
//		String title=workouts.getCategory().getTitle();
		if(categoryId>0)
		{
			Optional<Category> cf=categoryRepsitory.findById(categoryId);
//			Optional<Category> tf=categoryRepsitory.findByTitle(title);
			if(cf.isPresent()) {
				workouts.setCategory(cf.get());
			}
//			if(tf.isPresent()) {
//				workouts.setCategory(tf.get());
//			}
		}
		workoutsRepository.save(workouts);
		
	}
	@GetMapping("/g")
	public List<Workouts> getWorkouts(){
		return workoutsRepository.findAll();
		
	}
	@GetMapping("/c")
	public List<Category> getCategory(){
		return categoryRepsitory.findAll();
		
	}
	
}
