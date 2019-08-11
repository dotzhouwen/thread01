package com.zw;

import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) {
       ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
       for (int i = 0; i < 100; i++) {
           scheduledExecutorService.schedule(new TestThread(), 5, TimeUnit.SECONDS);
       }
       scheduledExecutorService.shutdown();
    }

}
class TestThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
