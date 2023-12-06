package com.lnt.day2;

public class EmployeeTest {
    public static void main(String[] args) {
        // Employee employee = new Employee(23, "Rahul");

        Employee regularEmployee = new RegularEmployee(1, "Shubham", 100000);

        Employee contractEmployee = new ContractEmployee(100, "Shaurya", 10000);

        Employee employees [] = {regularEmployee, contractEmployee};

        for(Employee e : employees){
            e.applyLeave();
            e.incrementSalary();
            e.mandatoryLeave();
            System.out.println(e);
        }
    }
}
