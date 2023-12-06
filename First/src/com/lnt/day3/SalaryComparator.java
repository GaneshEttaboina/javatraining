package com.lnt.day3;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        // return (int)(o1.salary - o2.salary);
        return o1.salary.compareTo(o2.salary);

    }
    
}
