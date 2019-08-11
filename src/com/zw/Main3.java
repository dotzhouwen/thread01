package com.zw;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallThread callThread = new CallThread();
        FutureTask<Integer> futureTask = new FutureTask<>(callThread);
        Thread t = new Thread(futureTask);
        t.start();

        System.out.println(futureTask.isDone());
        Integer i = futureTask.get();
        System.out.println(i);
        System.out.println(futureTask.isDone());
    }
}

class CallThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(10);
    }
}
