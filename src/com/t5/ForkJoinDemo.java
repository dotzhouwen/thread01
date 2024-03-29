package com.t5;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinDemo {
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println("nums:" + Arrays.stream(nums).sum());
    }

    static class AddTask extends RecursiveAction {

        int start, end;

        AddTask(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                System.out.println("from:" + start + " to: " + end + " = " + sum);
            } else {
                int middle = start + (end - start) / 2;
                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        AddTask task = new AddTask(0, nums.length);
        forkJoinPool.execute(task);

//        long result = task.join();
//        System.out.println(result);
        System.in.read();
    }
}
