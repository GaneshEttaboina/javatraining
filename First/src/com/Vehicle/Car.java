package com.Vehicle;

public class Car extends Vehicle {
        boolean automatic;
        boolean sports;
        public Car(){
            super();
        }
        public Car(int speed, String model, String color, boolean automatic, boolean sports) {
            super(speed, model, color);
            this.automatic = automatic;
            this.sports = sports;
        }
        public int speedUp(){
            System.out.println("SpeedUp:");
            if(sports)
            return speed++;
            else{
                System.out.println("Car is not a sports car,Max speed is:"+speed);
                return speed;
            }
            
        }
       
        public String changeGear(){
            if (automatic) {
                return "Automatically Gear will change";
            }
            return "Manually";
        }
        @Override
        public String toString() {
            return "Car [Model=" + model + ", Speed = " + speed + ", Color = " + color + " Automatic = " + automatic + ", Sports = " + sports + "]";
        }
        

}
