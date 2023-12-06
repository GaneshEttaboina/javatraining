package com.lnt.day2;

public class ContractEmployee extends Employee{

    double payPerDay;

    public ContractEmployee(int id, String name, double payPerDay) {
        super(id, name);
        this.payPerDay = payPerDay;
    }

    @Override
    public String toString() {
        return "ContractEmployee [ id=" + id + ", name=" + name   + "payPerDay=" + payPerDay + "]";
    }

    
    @Override
    public void incrementSalary() {
            this.payPerDay += 5000;
    }
        
    @Override
    public void mandatoryLeave(){
        System.out.println("Mandatory 0 days off!");
    }

}
