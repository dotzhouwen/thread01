package com.t1;

import java.util.ArrayList;
import java.util.List;

public class MyContainer2 {
    public static void main(String[] args) {
        final Object lock = new Object();
        List<Integer> list = new ArrayList<>();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 start");
                if (list.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 end");
                lock.notifyAll();
            }
        }, "t2").start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 start");
                for (int i = 0; i < 10; i++) {
                    list.add(i);
                    System.out.println("list add " + i);
                    if (list.size() == 5) {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("t1 end");
            }
        }, "t1").start();
    }
}
