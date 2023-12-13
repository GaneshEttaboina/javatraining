package com.lnt.workoutapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lnt.workoutapp.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer>{

    
} 
