package com.example.workoutApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workoutApplication.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
