package com.t3;

import java.util.LinkedList;

/**
 * 写一个固定容量的同步容器, 拥有put和get方法, 以及getCount方法, 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * 使用wait和notifyAll来实现
 *
 */
public class MyContainer<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private final int MAX = 3;
    private int count = 0;

    public synchronized void put(T t) {
        while (list.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get() {
        T t = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        MyContainer<String> container = new MyContainer<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(container.get());
                }
            }, "c" + i).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    container.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i).start();
        }
    }
}
