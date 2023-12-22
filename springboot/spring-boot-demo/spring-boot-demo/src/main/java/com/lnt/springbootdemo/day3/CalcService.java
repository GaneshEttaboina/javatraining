package com.lnt.springbootdemo.day3;

import org.springframework.stereotype.Service;

@Service

public class CalcService {
    
    public int add(int x, int y){
        return x+y;
    }
}
