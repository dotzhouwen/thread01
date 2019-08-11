package com.t5;

import java.util.concurrent.*;

public class FutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(6);
        Future<Integer> f = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        service.shutdown();
        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());
    }
}
