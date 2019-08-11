package com.t5;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkStealingPoolDemo {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());

        service.execute(new R(1));
        service.execute(new R(2));
        service.execute(new R(3));
        service.execute(new R(4));

        System.in.read();
    }

    static class R implements Runnable {
        int time;

        R(int i) {
            this.time = i;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(this.time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
