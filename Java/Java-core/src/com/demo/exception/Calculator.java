package com.demo.exception;

import java.sql.SQLOutput;

class Calculator {
    public void add(int num1, int num2) {
        System.out.println(num1 + num2);
    }

    public void sub(int num1, int num2) {
        System.out.println(num1 - num2);
    }

//    public static void main(String[] args) {
//        String color[] = {"Blue", "Orange", "Green"};
//
//        try {
//            for(int i=0; i<= 3; i--) {
//                System.out.println(color[i]);
//            }
//        }catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
//            System.out.println("Check index");
//        }catch(NullPointerException nullPointerException) {
//            System.out.println("Instantiate the calculator");
//        }
//    }
}
