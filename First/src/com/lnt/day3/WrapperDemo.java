package com.lnt.day3;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WrapperDemo {
    public static void main(String[] args) {
        // auto boxing
        Integer i = 34;

        int result = i * 45;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(34);

        String str = "abc";
        String str2 = new String("abc");

        System.out.println(str == str2);
        System.out.println(str.equals(str2));


    }
}
