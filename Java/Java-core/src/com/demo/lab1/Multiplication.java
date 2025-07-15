package com.demo.lab1;
import java.util.*;

public class Multiplication {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int n = sc.nextInt();

        //int i = 1;
//        while(i <= 10) {
//            System.out.println(n + " x " + i + " = " + n * i);
//            i += 1;
//        }

//        do{
//            System.out.println(n + " x " + i + " = " + n * i);
//            i += 1;
//        }
//        while(i <= 10);

        for(int i=1; i<=10; i++) {
            System.out.println(n + " x " + i + " = " + n * i);
        }
    }
}
