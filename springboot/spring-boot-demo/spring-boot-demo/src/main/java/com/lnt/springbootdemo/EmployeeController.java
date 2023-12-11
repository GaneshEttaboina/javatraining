package com.lnt.springbootdemo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class EmployeeController {

    static List<Employee> employees = new ArrayList<>();

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
    //    return new Employee(32, "Dipak", 34343.34);
        return employees;

    }

    // public Employee getAnEmployee(){

    // }

    @PostMapping("/employees")
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee){

        ResponseEntity<Void> re = null;

        System.out.println("Creating employee "+ employee);
        employees.add(employee);
        re = new ResponseEntity<>(HttpStatus.CREATED);
        return re;
        
    }


    
}
