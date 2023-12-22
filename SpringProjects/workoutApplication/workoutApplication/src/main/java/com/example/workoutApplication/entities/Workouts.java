package com.example.workoutApplication.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
//import lombok.Data;

@Entity
//@Data
public class Workouts {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    int id;

	    String title;
	    String description;
	    int cbpm;
	    
	    
	    
	    public Workouts() {
		}

		public Workouts(int id, String title, String description, int cbpm, Category category) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.cbpm = cbpm;
			this.category = category;
		}

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



		public String getDescription() {
			return description;
		}



		public void setDescription(String description) {
			this.description = description;
		}



		public int getCbpm() {
			return cbpm;
		}



		public void setCbpm(int cbpm) {
			this.cbpm = cbpm;
		}



		public Category getCategory() {
			return category;
		}



		public void setCategory(Category category) {
			this.category = category;
		}



		@ManyToOne(cascade = CascadeType.ALL)
	    Category category;
}
