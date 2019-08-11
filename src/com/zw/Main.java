package com.zw;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {
//        ConcurrentLinkedDeque<String> clq = new ConcurrentLinkedDeque<>();
//        clq.add("Java");
//        clq.add("html");
//        clq.add("css");
//
//        String ret = clq.poll();
//        System.out.println(ret);
//        System.out.println(clq.size());
        BlockingDeque<String> bq = new LinkedBlockingDeque<>(3);
        bq.add("java");
        bq.add("html");
        bq.add("css");

        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
    }
}
