package com.t1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyContainer3 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        List<Integer> list = new ArrayList<>();

        new Thread(() -> {
            System.out.println("t2 start");
            if (list.size() != 5) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 end");
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("add " + i);
                if (list.size() == 5) {
                    latch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
    }
}
