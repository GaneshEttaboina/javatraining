package com.lnt.springbootdemo.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "Employee API", description = "Employee management APIs")
@RestController 
@RequestMapping("/api/v1") 
public class EmpController {

	
	@Autowired
	EmployeeRepository employeeRepository;

	// static List<Employee> employees = new ArrayList<>();
	Map<Integer, Employee> employeeMap = new HashMap<>();

	@Operation(
		      summary = "Retrieve a Employees",
		      description = "Get a Emmployee object by specifying its id. The response is Employee object with id, title, description and published status.",
		      tags = { "employee", "get" })
		  @ApiResponses({
		      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Employee.class), mediaType = "application/json") }),
		      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
		      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
    }

	@GetMapping("/employees/find") // '/api/v1/employees/find?NAME=AG' THIS IS REQUEST PARAM, taking fields using query param from path of url
	public List<Employee> getEmployeeByName(@RequestParam("name") String name) {
		List<Employee> emp = employeeRepository.findByName(name);

		return emp;
	}
	
//	@GetMapping("/employees/find")
//	public List<Employee> getEmployeeByTop(@RequestParam("Salary") double Salary ) {
//		List<Employee> emp = employeeRepository.findTopBySalary(Salary);
//
//		return emp;
//	}

	@GetMapping("/employees/{id}")  // ''/api/v1/employees/find/26' taking id from path of the url'
	public ResponseEntity<Employee> getAnEmployee(@PathVariable("id") int id) {
		System.out.println("Id is : " + id);
		// return

		ResponseEntity<Employee> re = null;
		// for(Employee e : employees){
		// if(e.id == id){
		// re = new ResponseEntity<>(e, HttpStatus.OK);
		// return re;
		// }
		// }
		
//        employeeRepository.findBy
		Optional<Employee> employeeFound = employeeRepository.findById(id);

		if (employeeFound.isPresent()) {
			re = new ResponseEntity<>(employeeFound.get(), HttpStatus.OK);
			return re;
		} else
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return re;
	}

	@PostMapping("/employees") 
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee) {

		ResponseEntity<Void> re = null;

		System.out.println("Creating employee " + employee);

		// employees.add(employee);
//        employeeMap.put(employee.getId(), employee);

		employeeRepository.save(employee);
		re = new ResponseEntity<>(HttpStatus.CREATED);
		return re;

	}

	/*
	 * @RequestMapping(path="/employees/{id}", method = RequestMethod.DELETE) public
	 * ResponseEntity<Void> deleteEmployee(@PathVariable("id")int id){ Employee e =
	 * employeeMap.get(id); ResponseEntity<Void> re = null; if(e == null){ re = new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); return re; } employeeMap.remove(id);
	 * return new ResponseEntity<>(HttpStatus.OK); }
	 */
//    
	@PutMapping("/employees/{id}")                                   
	public ResponseEntity<Void> updateEmployee(@PathVariable("id") int id, @RequestBody  Employee    employee) {

		ResponseEntity<Void> re = null;
		Optional<Employee> employeeFound = employeeRepository.findById(id);
        
		if (employeeFound.isPresent()) {
			Employee employeeFromDb = employeeFound.get();
			employeeFromDb.setName(employee.getName());
			employeeFromDb.setSalary(employee.getSalary());
			
			employeeRepository.save(employeeFromDb);
			
			re = new ResponseEntity<>(HttpStatus.OK);
			return re;
		} else
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return re;

	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
//        	Employee e = employeeMap.get(id);
		ResponseEntity<Void> re = null;
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isEmpty()) {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return re;
		}
		employeeRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}

// public interface EmployeeService