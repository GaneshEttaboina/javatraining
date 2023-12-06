package com.Vehicle;

public class Plane extends Vehicle {
    
    int altitude;

    

    public Plane(int speed, String model, String color, int altitude) {
        super(speed, model, color);
        this.altitude = altitude;
    }



    public void fly(){
        System.out.println("plane flying..");
    }



    @Override
    public String toString() {
        return "Plane [altitude=" + altitude + "]";
    }

    

}
