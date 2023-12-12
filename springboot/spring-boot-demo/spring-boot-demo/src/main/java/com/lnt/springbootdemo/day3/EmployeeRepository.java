package com.lnt.springbootdemo.day3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByName(String name);
}
