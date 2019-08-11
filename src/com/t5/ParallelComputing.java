package com.t5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelComputing {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        MyTask t1 = new MyTask(1, 80000);
        MyTask t2 = new MyTask(80001, 130000);
        MyTask t3 = new MyTask(130001, 170000);
        MyTask t4 = new MyTask(170001, 200000);

        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);

        service.shutdown();

        List<Integer> f1List = f1.get();
        List<Integer> f2List = f2.get();
        List<Integer> f3List = f3.get();
        List<Integer> f4List = f4.get();

        printList(f1List);
        printList(f2List);
        printList(f3List);
        printList(f4List);
    }

    private static <T> void printList(List<T> list) {
        list.forEach(System.out::println);
    }

    static class MyTask implements Callable<List<Integer>> {
        int startPos, endPos;
        MyTask(int s, int e) {
            this.startPos = s;
            this.endPos = e;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> r = getPrime(startPos, endPos);
            return r;
        }
    }
    private static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static List<Integer> getPrime(int start, int end) {
        List<Integer> results = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                results.add(i);
            }
        }
        return results;
    }
}
