package com.demo.FunctionallInterface;

public class Main {

    public static void main(String args[]) {
        FunctionalInterface obj = () -> {
            int a = 10;
            int b = 10;

            System.out.println(a + b);
        };

        obj.sayHello();
    }
}
