package com.demo.lab2;

import java.util.Scanner;

public class Greater {

    public int greaterNumber(int num1, int num2, int num3) {
        if(num1 > num2 && num1 > num3) {
            return num1;
        } else if (num2 > num1 && num2 > num3) {
            return num2;
        }
        else {
            return num3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: " );
        int num1 = sc.nextInt();

        System.out.print("Enter sec number: " );
        int num2 = sc.nextInt();

        System.out.print("Enter third number: " );
        int num3 = sc.nextInt();

        Greater gt = new Greater();

        System.out.println(gt.greaterNumber(num1, num2, num3));
    }
}
