package com.lnt.springbootdemo.d3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    double salary;
    String department;
    int age;

    public Employee(){

    }
    
    
    public Employee(int id, String name, double salary, String department, int age) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}


    
    
}
