package com.lnt.springbootdemo.day3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByNameLike(String name);

	List<Employee> findTop3ByOrderBySalary();

	List<Employee> findByNameContaining(String infix);

    List<Employee> findByName(String likePattern1);

	// List<Employee> empsWithLowestSalary();
	

	//List<Employee> findTopBySalary(double salary);
//	List<Employee> findByAge(int age);
}
