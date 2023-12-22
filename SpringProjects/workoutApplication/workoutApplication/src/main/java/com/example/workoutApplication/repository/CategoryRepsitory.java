package com.example.workoutApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workoutApplication.entities.Category;

public interface CategoryRepsitory extends JpaRepository<Category, Integer> {

	Optional<Category> findByTitle(String title);

}
