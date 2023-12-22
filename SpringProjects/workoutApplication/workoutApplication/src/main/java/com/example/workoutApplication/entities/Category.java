package com.example.workoutApplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import lombok.Data;


	@Entity
//	@Data
	public class Category {
	     @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    int id;
	    @Column(unique = true)
	    String title;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public Category() {
		}
		public Category(int id, String title) {
			super();
			this.id = id;
			this.title = title;
		}
	    
	}
