package com.lnt;
public class A {

    // hard -baked solution... tightly coupled
    // B b = new B();


    // loosely coupled
    B b;
    public A(B b) {
        this.b = b;
    }



    public void execute(){
        System.out.println("execute in A..");
        b.execute();
    }
}
