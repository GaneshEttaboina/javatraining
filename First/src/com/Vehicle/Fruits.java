package com.Vehicle;
import java.util.ArrayList;
import java.util.Collections;
public class Fruits implements Comparable<Fruits> {
    String name;
    String color;
    

    public Fruits(String name, String color) {
        this.name = name;
        this.color = color;
    }


    @Override
    public String toString() {
        return "Fruits [name=" + name + ", color=" + color + "]";
    }


    @Override
    public int compareTo(Fruits o) {
       return this.name.compareTo(o.name);
    }
    public static void main(String[] args) {
        Fruits f1=new Fruits("Mango", "Yellow");
        Fruits f2=new Fruits("Banana", "Yellow");
        Fruits f3=new Fruits("Apple", "Red");
        ArrayList<Fruits> fruits=new ArrayList<>();
        fruits.add(f1);
        fruits.add(f2);
        fruits.add(f3);
        System.out.println(fruits);
        Collections.sort(fruits);
        System.out.println(fruits);

    }
    
}
