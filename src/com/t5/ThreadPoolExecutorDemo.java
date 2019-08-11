package com.t5;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 8, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2));
//        for (int i = 0; i < 14; i++) {
//            executor.execute(() -> {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//        executor.shutdown();
        Executors.newSingleThreadExecutor();
    }
}
