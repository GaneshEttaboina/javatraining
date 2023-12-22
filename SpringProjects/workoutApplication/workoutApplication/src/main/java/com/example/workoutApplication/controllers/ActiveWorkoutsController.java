package com.example.workoutApplication.controllers;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workoutApplication.entities.ActiveWorkouts;
import com.example.workoutApplication.entities.Category;
import com.example.workoutApplication.entities.Users;
import com.example.workoutApplication.entities.Workouts;
//import com.example.workoutApplication.entities.Category;
import com.example.workoutApplication.repository.ActiveWorkoutsRepository;
import com.example.workoutApplication.repository.UsersRepository;
import com.example.workoutApplication.repository.WorkoutsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/AW")
public class ActiveWorkoutsController {

	
	@Autowired
	ActiveWorkoutsRepository activeWorkoutsRepository;
	@Autowired
	WorkoutsRepository workoutsRepository;
	@Autowired
	UsersRepository usersRepository;
	@PostMapping("/ad")
	public void createActiveWorkout(@RequestBody ActiveWorkouts activeWorkouts) {
		activeWorkouts.setStartTime(LocalTime.now());
		int wid=activeWorkouts.getWorkouts().getId();
		int uid=activeWorkouts.getUser().getId();

		if(wid>0&&uid>0)
		{
			Optional<Workouts> wf=workoutsRepository.findById(wid);
			Optional<Users> uf=usersRepository.findById(uid);
			if(wf.isPresent()&&uf.isPresent())
			{
				activeWorkouts.setWorkouts(wf.get());
				activeWorkouts.setUser(uf.get());
			}
		}
		activeWorkoutsRepository.save(activeWorkouts);
		}
	

	@Operation(
		      summary = "Retrieve a Employees",
		      description = "Get a Emmployee object by specifying its id. The response is Employee object with id, title, description and published status.",
		      tags = { "employee", "get" })
		  @ApiResponses({
		      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ActiveWorkouts.class), mediaType = "application/json") }),
		      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
		      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/c")
	public List<ActiveWorkouts> getActiveWorkouts(){
	return activeWorkoutsRepository.findAll();
	
}
}
