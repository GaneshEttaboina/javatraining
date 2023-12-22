package com.lnt.day4;

class MyTask implements Runnable{

    @Override
    public void run() {
        System.out.println("This is executed by thread: " + Thread.currentThread().getName());
    }
    
}

public class ThreadDemo {
    public static void main(String[] args) {
        // Create Thread
        Thread t = new Thread(new MyTask());
        t.start();
        Thread t1 = new Thread(new MyTask());
        t1.start();

        Thread t2 = new Thread(()-> System.out.println(Thread.currentThread().getName()));

        System.out.println("Main method executed by " + Thread.currentThread().getName());
    }
}
