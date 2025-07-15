package com.demo.lab2;

import java.util.*;

public class HelloMethod {

    public String returnName(String str) {
        return "Hello " + str + ", Welcome to Java World!";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Beautiful Name: " );
        String name = sc.next();

        HelloMethod hl = new HelloMethod();

        System.out.println(hl.returnName(name)); //argument
    }
}
