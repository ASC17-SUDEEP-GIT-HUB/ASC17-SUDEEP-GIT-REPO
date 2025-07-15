package com.demo.exception;

public class UnhandledException {

    public static void main(String[] args) {
        try {
            int i = 100;
            System.out.println("divide by zero");
            int result = i / 0;

            System.out.println(result);
        }catch(Exception e) {
            System.out.println("Exception is :" + e);
            System.out.println("Messege is : " + e.getMessage());

        } finally {
            System.out.println("Thank you");
        }
    }
}