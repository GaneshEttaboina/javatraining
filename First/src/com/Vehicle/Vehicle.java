package com.Vehicle;

public class Vehicle extends Object{
    int speed;
    String model;
    String color;
    public Vehicle(){
        
    }
    public int speedDown(){
        return speed--;
    }
    public Vehicle(int speed, String model, String color) {
        this.speed = speed;
        this.model = model;
        this.color = color;
    }

    public static void main(String[] args) {
        Car v=new Car(185,"MG Hector","Black",true,false);
        System.out.println(v);
        v.speedUp();
        System.out.println(v);
        v.speedDown();
        System.out.println(v.changeGear());
        System.out.println(v);

        Vehicle v2=v;    //implicit typecast
        System.out.println(v2);

        Plane plane = new Plane(900, "Boieng", "Blue"  , 10000);
        
        Vehicle vehicles[] = {v, plane};

        for(Vehicle vehicle: vehicles){
            System.out.println(vehicle);
            vehicle.speedDown();
            System.out.println(vehicle);
            if(vehicle instanceof Plane){
                Plane p = (Plane) vehicle;
                p.fly();
            }
           
        }


    }
    @Override
    public String toString() {
        return "Vehicle [speed = " + speed + ", model = " + model + ", color=" + color + "]";
    }
    
}
