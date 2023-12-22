package com.lnt.springbootdemo.d3;

import java.awt.print.Pageable;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




import java.util.Optional;
@RestController
@RequestMapping("/a/b")
public class EmpController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	PagingRepository pero;
	 // static List<Employee> employees = new ArrayList<>();
    Map<Integer, Employee> employeeMap = new HashMap<>();
//findAll
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
//        List<Employee> employees = new ArrayList<>();
//        for(Integer key : employeeMap.keySet()){
//            employees.add(employeeMap.get(key));
//        }

        return employeeRepository.findAll();
    }
	//post
//  @RequestMapping(path="/employees",method=RequestMethod.POST)
    @PostMapping("/employees")
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee){

        ResponseEntity<Void> re = null;

        System.out.println("Creating employee "+ employee);
//        employeeMap.put(employee.getId(), employee);
        employeeRepository.save(employee);
        re = new ResponseEntity<>(HttpStatus.CREATED);
        return re;
    }
    
    //Get id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getAnEmployee(@PathVariable("id") int id){
    	
    	ResponseEntity<Employee> re=null;
    	
    	Optional<Employee> employeeFound = employeeRepository.findById(id);
        if(employeeFound.isPresent()){
            re = new ResponseEntity<>(employeeFound.get(), HttpStatus.OK);
            return re;
       }
       else
       re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
       return re;	
    }
    
 // Update
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee) {
    	
    	ResponseEntity<Employee> re=null;
    	
    	Optional<Employee> employeeFound = employeeRepository.findById(id);
        if(employeeFound.isPresent()){
        	employee.id=id;
            re = new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
            return re;
        	}
       else
       re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
       return re;	
 
    	
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
//    	Employee e = employeeMap.get(id);
        ResponseEntity<Void> re = null;
        Optional<Employee> emp=employeeRepository.findById(id);
        if(emp.isEmpty()){
             re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
             return re;
        }
        employeeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
 
    }
    @GetMapping("/employee/find")
    public List<Employee> getEmployeeByName(@RequestParam("name") String name) {
    	List<Employee> emp=employeeRepository.findByName(name);
    	if(emp.isEmpty())
    		return null;
    	else
    	return emp;
		
	}
    
    
    
    //Fetching data
    
    @GetMapping("/employees/fetchsalaryLessthan")
    public List<Employee> getEmployees(@RequestParam("salary") double salary){
    	List<Employee> emp=employeeRepository.findBySalaryLessThan(salary);
    	
    	if(emp.isEmpty())
    		return null;
    	else
    	return emp;
    		
    }
    @GetMapping("/employees/top")
    public List<Employee> getEmployeesTopSalary(@RequestParam("salary") double salary){
//    	List<Employee> emp=employeeRepository.findTop2BySalary(salary);
//    	if(emp.isEmpty())
//    		return null;
//    	else
    	return employeeRepository.findTop2BySalary(salary);
    		
    }
    @GetMapping("/employees/fetchage")
    public List<Employee> getEmployeesAge(@RequestParam("sage") int startAge,@RequestParam("eage")int endAge ){
    	List<Employee> emp=employeeRepository.findByAgeBetween(startAge,endAge);
    	
    	if(emp.isEmpty())
    		return null;
    	else
    	return emp;
    		
    }
    @GetMapping("/employees/fetchName")
    public List<Employee> getEmployeeByNameByOrder() {
    	List<Employee> emp=employeeRepository. findByOrderByName();
    	if(emp.isEmpty())
    		return null;
    	else
    	return emp;
		
	}
    @GetMapping("/employees/fetchaget")
    public List<Employee> getEmployeeByAge() {
    	List<Employee> emp=employeeRepository. findTop3ByOrderByAge();
    	if(emp.isEmpty())
    		return null;
    	else
    	return emp;
		
	}
    @GetMapping("/employees/namecontains")
    public List<Employee> getNameContaining(@RequestParam("name") String name){
    	List<Employee> emp=employeeRepository.findByNameContaining(name);
    	if(emp.isEmpty())
    		return null;
    	else
    	return emp;
    }

    @GetMapping("/employees/likepattern")
    public List<Employee> findNameLike(){
    	String name="P%n";
    	List<Employee> emp=employeeRepository.findByNameLike(name);
    	if(emp.isEmpty())
    		return null;
    	else
    	return emp;
    }
    @GetMapping("/employees/findnameorage")
    public List<Employee> findNameOrAge(@RequestParam("name")String name,@RequestParam("age")int age){
    	List<Employee> emp=employeeRepository.findByNameOrAge(name,age);
    	if(emp.isEmpty())
    		return null;
    	else
    	return emp;
    }

    
//    //Pagination and sorting
//    @GetMapping("/ab/{pn}/{ps}")
//    
////    public Page<Employee> get(@PathVariable int pn,@PathVariable int ps){
////    	
////    	 Pageable p=PageRequest.of(pn, ps);
////    	 return pero.findAll(p);
////    	
////    }
}
