package org.demo;

import java.util.Scanner;

public class ArrayStore {

    int arr[] = new int[10];

    public void storeToArray(int arr[]) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(i < 10) {
            System.out.println("Enter the number: ");
            arr[i] = sc.nextInt();
            i++;
        }
    }
}
