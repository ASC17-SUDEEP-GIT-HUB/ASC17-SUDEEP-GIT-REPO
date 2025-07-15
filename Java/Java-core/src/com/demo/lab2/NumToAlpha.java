package com.demo.lab2;

import java.util.*;

public class NumToAlpha {

    public void numToAlphabet(int num) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");


        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            int digit = num % 10;
            sb.append(map.get(digit) + " ");
            num = num / 10;

        }
        System.out.println(sb.reverse().reverse());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the three digit number: ");
        int num = sc.nextInt();

        NumToAlpha nm = new NumToAlpha();

        nm.numToAlphabet(num);
    }
}
