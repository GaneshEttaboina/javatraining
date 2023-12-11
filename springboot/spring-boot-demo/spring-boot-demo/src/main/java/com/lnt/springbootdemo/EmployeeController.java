package com.lnt.springbootdemo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class EmployeeController {

    
    @GetMapping("/employee")
    public Employee getEmployee(){
       return new Employee(32, "Priya", 34343.34);
    }
    
}
