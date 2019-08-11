package com.t1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer<T> {
    private volatile List<T> list = new ArrayList<>();
    public void add(T t) {
        list.add(t);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer<Integer> container = new MyContainer<>();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                container.add(i);
                System.out.println("add:" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                if (container.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 end");
        }, "t2").start();

    }
}
