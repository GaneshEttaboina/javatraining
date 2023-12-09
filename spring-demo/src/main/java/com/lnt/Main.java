package com.lnt;
import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // B b = new B();
        // A a = new A(b);

        // Srping code

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		A a = context.getBean(A.class);
		a.execute();
    }
}