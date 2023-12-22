package com.example.workoutApplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workoutApplication.entities.ActiveWorkouts;
import com.example.workoutApplication.entities.Users;
import com.example.workoutApplication.repository.UsersRepository;

@RestController
@RequestMapping("/User")
public class UsersController {

	@Autowired
	UsersRepository usersRepository;
	
	@PostMapping("/create")
	public void createUser(@RequestBody Users user) {
		usersRepository.save(user);
		
	}
	@GetMapping("/c")
	public List<Users> getUsers(){
	return usersRepository.findAll();
}
}