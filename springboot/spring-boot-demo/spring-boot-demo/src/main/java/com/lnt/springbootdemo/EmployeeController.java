package com.lnt.springbootdemo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
  import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



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

    // @PutMapping() use id with PathVariable and employee with RequestBody
    public void updateEmployee(@PathVariable("id")int id, @RequestBody Employee employee){
        // employeeMap.put(id, value)
    }


    
}
