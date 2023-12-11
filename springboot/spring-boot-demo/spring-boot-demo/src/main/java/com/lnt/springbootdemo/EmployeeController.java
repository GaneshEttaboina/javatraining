package com.lnt.springbootdemo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.*;

import org.springframework.http.HttpStatus;
  import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
public class EmployeeController {

    // static List<Employee> employees = new ArrayList<>();
    Map<Integer, Employee> employeeMap = new HashMap<>();

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
    //    return new Employee(32, "Priya", 34343.34);
        // return employeeMap.entrySet();
        List<Employee> employees = new ArrayList<>();
        for(Integer key : employeeMap.keySet()){
            employees.add(employeeMap.get(key));
        }

        return employees;
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getAnEmployee(@PathVariable("id") int id){
        System.out.println("Id is : " + id);
        // return 

        ResponseEntity<Employee> re = null;
        // for(Employee e : employees){
        //     if(e.id == id){
        //         re = new ResponseEntity<>(e, HttpStatus.OK);
        //         return re;
        //     }
        // }
    
        Employee e =  employeeMap.get(id);
        if(e != null){
             re = new ResponseEntity<>(e, HttpStatus.OK);
             return re;
        }
        else
        re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return re;
    }


    @PostMapping("/employees")
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee){

        ResponseEntity<Void> re = null;

        System.out.println("Creating employee "+ employee);
        // employees.add(employee);
        employeeMap.put(employee.getId(), employee);
        re = new ResponseEntity<>(HttpStatus.CREATED);
        return re;
        
    }

    @RequestMapping(path="/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id")int id){
        Employee e = employeeMap.get(id);
        ResponseEntity<Void> re = null;
        if(e == null){
             re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
             return re;
        }
        employeeMap.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

        @PutMapping("/employees/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee) {
    	// employee.id=id;
    	// employee.name="Rakesh";
    	// employee.salary=6675;

        Employee e = employeeMap.get(id);
        ResponseEntity<Void> re = null;
        if(e == null){
             re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
             return re;
        }

    	employeeMap.put(id,employee);
         re = new ResponseEntity<>(HttpStatus.OK);
             return re;

    }


    
}
