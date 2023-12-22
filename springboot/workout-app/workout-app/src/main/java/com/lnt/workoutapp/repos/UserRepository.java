package com.lnt.workoutapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lnt.workoutapp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
