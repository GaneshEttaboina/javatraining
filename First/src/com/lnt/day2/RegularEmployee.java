package com.lnt.day2;

public class RegularEmployee extends Employee{

    double salary;

    @Override
    public void mandatoryLeave(){
        System.out.println("Mandatory 15 days off!");
    }

    public RegularEmployee(int id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }



    public double incrementSalary(double incrementAmount){
        this.salary += incrementAmount;
        return this.salary;
    }

    @Override
    public String toString() {
        return "RegularEmployee [ id=" + id + ", name=" + name   + "salary=" + salary + "]";
    }



    @Override
    public void incrementSalary() {
            this.salary *= 1.1;
    }



}
