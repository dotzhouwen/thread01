package com.streamtest;

import com.streamtest.eg.Trader;
import com.streamtest.eg.Transaction;
import com.streamtest.eg.TransactionUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main1 {
    public static void main(String[] args) {
        List<Transaction> transactions = TransactionUtil.createTransactions();
        Optional<Transaction> transaction = transactions.stream().max(Comparator.comparing(Transaction::getValue));
        transaction.ifPresent(t -> {
            System.out.println(t.getValue());
        });
    }

    private static <T> void print(T t) {
        System.out.print(t);
    }
}
