package com.example.ProductsApplication.Repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductsApplication.Entities.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

	List<Products> findByName(String name);

	List<Products> findByDescriptionContaining(String description);

	

	List<Products> findByPriceGreaterThan(double price);


	List<Products> findByManufacturingDateEquals(Date mfd);

	List<Products> findByOrderByName();
	

}
