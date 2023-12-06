package com.lnt.day2;
public abstract class Employee implements Perks{
    int id;
    String name;
    // double salary;


    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        // this.salary = salary;
    }

    public abstract void incrementSalary();

   

    public void applyLeave(){
        System.out.println("Please grant me leave!");
    }

    // constructor for initializing mandatory fields
    public Employee(){

    }
    public Employee(int id, String name,String c){
        this.id = id;
        this.name = name;
        // salary = s;
        
    }

    // public String toString(){
    //     return this.id + ": "  + this.name;
    // }
        // public String changeCity(String city)
        // {
        //     this.city=city;
        //     return "New City : "+this.city;
        // }
    
    public static void main(String[] args) {
        // create object of employee
        // Address address = new Address(23, "Jangpura", "Delhi");
        // Employee e = new Employee(12, "Priya");
        // e.name = "Amit";
        // System.out.println(e.toString());
        // // System.out.println(e.incrementSalary(5000));
        // // System.out.println(e.changeCity("Coimbatore"));
        // System.out.println(e);

        Manager m = new Manager(44, "Ravi", 5);
        System.out.println(m.name);
        System.out.println(m);
        
        // implicit typecast
        Employee e1 = m;

        //  Employee e1 = new Employee();
        // Object e2=new Employee();

        // explicit typecast
        if(e1 instanceof Manager){
        Manager m1 = (Manager) e1;

        System.out.println(m1.teamSize);
        }
        

        byte b = (byte)134;
        int i = b;
        System.out.println(i);
    }

    // @Override
    // public String toString() {
    //     return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ",City="+ city+ "]";
    // }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name   + "]";
    }

    
}
