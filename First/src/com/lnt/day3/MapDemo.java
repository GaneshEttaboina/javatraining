package com.lnt.day3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee(12, "Ravi", 13433);
        Employee e5 = new Employee(12, "Ravi", 13433);
        Employee e2 = new Employee(11, "Priya", 43433);
        Employee e3 = new Employee(1, "Amit", 53433);
        Employee e4 = new Employee(2, "Bhanu", 23433);

        Map<Integer, Employee> employeeMap = new HashMap<>();
        employeeMap.put(12, e1);
        employeeMap.put(11, e2);
        employeeMap.put(1, e3);
        employeeMap.put(2, e4);

        System.out.println(employeeMap);

        System.out.println(employeeMap.get(12));

        Set<Integer> keys = employeeMap.keySet();
        System.out.println(keys);

        for(Integer key: keys){
            System.out.println(employeeMap.get(key));
        }
    }
}
