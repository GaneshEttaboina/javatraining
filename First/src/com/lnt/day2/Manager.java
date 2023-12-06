package com.lnt.day2;


public class Manager extends Employee {
    int teamSize;

    public Manager(){
        super();
    }

    public Manager(int id, String name, int teamSize){
        // this.id = id;
        super(id, name);
        this.teamSize = teamSize;
    }

    
    public void approveLeaves(){
        
    }

    @Override
    public String toString() {
        // String str = super.toString();
        return "Manager [id=" + id + ", name=" + name + ", salary="  + ", teamSize=" +teamSize + "]";
    }

    @Override
    public void incrementSalary() {
        System.out.println("You have earned enough!");
    }

    @Override
    public void mandatoryLeave(){
        System.out.println("Mandatory 5 days off!");
    }
    


}
