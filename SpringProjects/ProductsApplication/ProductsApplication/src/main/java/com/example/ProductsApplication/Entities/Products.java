package com.example.ProductsApplication.Entities;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	String name;
	String description;
	public double price;
	// @JsonFormat(pattern="yyyy-MM-dd")
	LocalDate  manufacturingDate;
//	LocalDate manufacturingDate;
	
	
	public Products() {
//		super();
	}


	public Products(int id, String name, String description, double price, LocalDate manufacturingDate) {
		super();
		id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}


	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}


	 
	

}
