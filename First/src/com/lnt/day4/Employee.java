package com.lnt.day4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

class IncrementSalaryTask implements Runnable{

    Employee employee;

    

    public IncrementSalaryTask(Employee employee) {
        this.employee = employee;
    }



    @Override
    public void run() {
    employee.incrementSalary();
    System.out.println(employee);
       System.out.println("Increment salary here .. by " + Thread.currentThread().getName());
    }
    
}

public  class Employee implements Comparable<Employee> {
    int id;
    String name;
    Double salary;


    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

   

    public void applyLeave(){
        System.out.println("Please grant me leave!");
    }

    public void incrementSalary(){
        this.salary *= 1.1;
    }

    // constructor for initializing mandatory fields
    public Employee(){

    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }


    public static void main(String[] args) {
        Employee e1 = new Employee(12, "Ravi", 13433);
        Employee e5 = new Employee(12, "Ravi", 13433);
        Employee e2 = new Employee(11, "Priya", 43433);
        Employee e3 = new Employee(1, "Amit", 53433);
        Employee e4 = new Employee(2, "Bhanu", 23433);

        Set<Employee> employees = new HashSet<>();
        // Set<Employee> employees = new LinkedHashSet<>();
        // Set<Employee> employees = new TreeSet<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        employees.stream()
        .filter((e)-> e.salary > 30000)
        .map(e-> e.salary)
        .sorted()
        .forEach(System.out::println);

        
        System.out.println(LocalDateTime.now());

        // .forEach(e-> System.out.println(e));

        // System.out.println(employees);

        // System.out.println(employees.contains(new Employee(11, "Priya", 43433) ));

        // for(Employee e : employees){
        //     // create a thread 
             
        //     Thread t = new Thread(new IncrementSalaryTask(e));
        //     t.start();
        //     // System.out.println(e);
        // }
    }



    @Override
    public int compareTo(Employee o) {
        // return this.id - o.id;
        return this.name.compareTo(o.name);
    }
    
}
