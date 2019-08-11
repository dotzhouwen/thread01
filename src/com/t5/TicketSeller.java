package com.t5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TicketSeller {
    static Vector<String> tickets = new Vector<>();
    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票号:" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    System.out.println("销售了--" + tickets.remove(0));
                }
            }).start();
        }
    }
}
