package com.lnt.day3;

import java.util.ArrayList;
import java.util.Collections;

public  class Employee implements Comparable<Employee> {
    int id;
    String name;
    double salary;


    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

   

    public void applyLeave(){
        System.out.println("Please grant me leave!");
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
        Employee e1 = new Employee(12, "Ravi", 33433);
        Employee e2 = new Employee(11, "Priya", 33433);
        Employee e3 = new Employee(1, "Amit", 33433);
        Employee e4 = new Employee(2, "Bhanu", 33433);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        System.out.println(employees);

        Collections.sort(employees);

        System.out.println(employees);

        System.out.println(e1.equals(e2));
    }



    @Override
    public int compareTo(Employee o) {
        // return this.id - o.id;
        return this.name.compareTo(o.name);
    }
    
}
