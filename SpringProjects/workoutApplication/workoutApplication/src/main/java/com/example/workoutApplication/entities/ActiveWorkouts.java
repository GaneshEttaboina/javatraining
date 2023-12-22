package com.example.workoutApplication.entities;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ActiveWorkouts {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	LocalTime startTime;
	LocalTime endTime;
	
	public ActiveWorkouts() {
//		super();
	}
	public ActiveWorkouts(int id, LocalTime startTime, LocalTime endTime, Workouts workouts,Users user){
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.workouts=workouts;
		this.user=user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "ActiveWorkouts [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	public Workouts getWorkouts() {
		return workouts;
	}
	public void setWorkouts(Workouts workouts) {
		this.workouts = workouts;
	}

	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}


	@OneToOne
	Workouts workouts;
	@OneToOne
	Users user;
	

}
