package com.lnt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

    // hard -baked solution... tightly coupled
    // B b = new B();


    // loosely coupled
    @Autowired
    B b;
    public A(B b) {
        this.b = b;
    }



    public void execute(){
        System.out.println("execute in A..");
        b.execute();
    }
}