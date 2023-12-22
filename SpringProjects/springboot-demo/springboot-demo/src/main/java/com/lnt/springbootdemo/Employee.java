package com.lnt.springbootdemo;


public class Employee {
    int id;
    String name;
    double salary;
    

    public Employee(){

    }
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]"; }

    
}
