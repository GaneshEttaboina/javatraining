package com.lnt.day3;

import java.util.ArrayList;

class Fruit{
    String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fruit [name=" + name + "]";
    }

  
    @Override
    public boolean equals(Object obj) {
        Fruit f = (Fruit) obj;
        return this.name.equals(f.name);
    }

    
    
}

public class ArrayListDemo {
    public static void main(String[] args) {
        // ArrayList<String> fruits = new ArrayList<>();
        // // list.add(23);
        // fruits.add("apple");
        // fruits.add("mango");
        // fruits.add("mango");

        // boolean result = fruits.contains("grape");
        // System.out.println(result);

        // System.out.println(fruits);

        ArrayList<Fruit> fruits = new ArrayList<>();

        Fruit apple1 = new Fruit("apple");
        Fruit apple2 = new Fruit("mango");

        System.out.println(apple1.equals(apple2));

        fruits.add(new Fruit("apple"));
        fruits.add(new Fruit("mango"));
        fruits.add(new Fruit("mango"));

        boolean result = fruits.contains(new Fruit("apple"));
        System.out.println(result);

        System.out.println(fruits);
    }
}
