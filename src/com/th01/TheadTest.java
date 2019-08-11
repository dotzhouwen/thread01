package com.th01;

public class TheadTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        Thread t = new Thread(r);
        t.start();

        t.join();
    }
}
