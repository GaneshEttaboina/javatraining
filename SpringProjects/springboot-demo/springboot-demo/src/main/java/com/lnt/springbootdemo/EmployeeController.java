package com.lnt.springbootdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeController {
	
	 // static List<Employee> employees = new ArrayList<>();
    Map<Integer, Employee> employeeMap = new HashMap<>();

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();
        for(Integer key : employeeMap.keySet()){
            employees.add(employeeMap.get(key));
        }

        return employees;
    }
	
//  @RequestMapping(path="/employees",method=RequestMethod.POST)
    @PostMapping("/employees")
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee){

        ResponseEntity<Void> re = null;

        System.out.println("Creating employee "+ employee);
        employeeMap.put(employee.getId(), employee);
        re = new ResponseEntity<>(HttpStatus.CREATED);
        return re;
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getAnEmployee(@PathVariable("id") int id){
    	ResponseEntity<Employee> re=null;
    	Employee e=employeeMap.get(id);
    	if(e!=null)
    	{
    		re=new ResponseEntity<>(e,HttpStatus.OK);
    		return re;
    	}
    	else
    	return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
    	
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee) {
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
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
    	Employee e = employeeMap.get(id);
        ResponseEntity<Void> re = null;
        if(e == null){
             re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
             return re;
        }
        employeeMap.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
 
    }
}
