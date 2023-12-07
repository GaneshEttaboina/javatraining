package com.lnt.day4;

public class ExceptionDemo {
    public static void m1(int x) {
        if(x<0)
         throw new InvalidInputException("Arg x cannot be less than zero");
    }

    public static void main(String[] args) {
        int x = 343;
        int y = 0;

        try{
             m1(-2);
        }
        catch(RuntimeException  e){
            // System.out.println;
            e.printStackTrace();
        } 
        

        try{
            System.out.println(x/y);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Use a positive value!");
        }
       

        System.out.println("Allz Well!");
    }
    
}
