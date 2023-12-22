package com.lnt.springbootdemo.d3;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByName(String name);
	List<Employee> findBySalaryLessThan(double salary);
	List<Employee> findByAgeBetween(int startAge,int endAge);
	List<Employee> findTop2BySalary(double salary);
	List<Employee> findByOrderByName();
	List<Employee> findTop3ByOrderByAge();
	List<Employee> findByNameContaining(String name);
	List<Employee> findByNameLike(String name);
	List<Employee> findByNameOrAge(String name, int age);
}
