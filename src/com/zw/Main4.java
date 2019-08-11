package com.zw;

import java.lang.reflect.Field;

public class Main4 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer n = new Integer(123);
        Class cls = n.getClass();
        Field f = cls.getDeclaredField("value");
        Object result = f.get(n);
        print(result);
    }
    private static <T> void print(T t) {
        System.out.println(t);
    }
}
