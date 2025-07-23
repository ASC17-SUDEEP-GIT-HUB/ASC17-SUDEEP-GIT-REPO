package com.demo;

import java.util.Arrays;
import java.util.List;

public class Stream {

    public static void main(String args[]) {
        List<String> fruits = Arrays.asList("Jack", "guvava", "apple", "mango", "banana", "blueberries");

        fruits.stream()
                .filter(fruit -> fruit.startsWith("b"))
                .map(String :: toUpperCase)
                .sorted()
                .forEach(System.out::println);

    }
}
